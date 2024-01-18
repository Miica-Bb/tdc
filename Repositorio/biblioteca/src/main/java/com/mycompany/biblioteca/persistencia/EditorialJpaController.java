package com.mycompany.biblioteca.persistencia;

import com.mycompany.biblioteca.logica.Editorial;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.biblioteca.logica.Libro;
import com.mycompany.biblioteca.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EditorialJpaController implements Serializable {

    public EditorialJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EditorialJpaController() {
        emf = Persistence.createEntityManagerFactory("bibliotecaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Editorial editorial) {
        if (editorial.getLibros() == null) {
            editorial.setLibros(new ArrayList<Libro>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Libro> attachedLibros = new ArrayList<Libro>();
            for (Libro librosLibroToAttach : editorial.getLibros()) {
                librosLibroToAttach = em.getReference(librosLibroToAttach.getClass(), librosLibroToAttach.getIsbn());
                attachedLibros.add(librosLibroToAttach);
            }
            editorial.setLibros(attachedLibros);
            em.persist(editorial);
            for (Libro librosLibro : editorial.getLibros()) {
                Editorial oldEditorialOfLibrosLibro = librosLibro.getEditorial();
                librosLibro.setEditorial(editorial);
                librosLibro = em.merge(librosLibro);
                if (oldEditorialOfLibrosLibro != null) {
                    oldEditorialOfLibrosLibro.getLibros().remove(librosLibro);
                    oldEditorialOfLibrosLibro = em.merge(oldEditorialOfLibrosLibro);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Editorial editorial) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Editorial persistentEditorial = em.find(Editorial.class, editorial.getId());
            List<Libro> librosOld = persistentEditorial.getLibros();
            List<Libro> librosNew = editorial.getLibros();
            List<Libro> attachedLibrosNew = new ArrayList<Libro>();
            for (Libro librosNewLibroToAttach : librosNew) {
                librosNewLibroToAttach = em.getReference(librosNewLibroToAttach.getClass(), librosNewLibroToAttach.getIsbn());
                attachedLibrosNew.add(librosNewLibroToAttach);
            }
            librosNew = attachedLibrosNew;
            editorial.setLibros(librosNew);
            editorial = em.merge(editorial);
            for (Libro librosOldLibro : librosOld) {
                if (!librosNew.contains(librosOldLibro)) {
                    librosOldLibro.setEditorial(null);
                    librosOldLibro = em.merge(librosOldLibro);
                }
            }
            for (Libro librosNewLibro : librosNew) {
                if (!librosOld.contains(librosNewLibro)) {
                    Editorial oldEditorialOfLibrosNewLibro = librosNewLibro.getEditorial();
                    librosNewLibro.setEditorial(editorial);
                    librosNewLibro = em.merge(librosNewLibro);
                    if (oldEditorialOfLibrosNewLibro != null && !oldEditorialOfLibrosNewLibro.equals(editorial)) {
                        oldEditorialOfLibrosNewLibro.getLibros().remove(librosNewLibro);
                        oldEditorialOfLibrosNewLibro = em.merge(oldEditorialOfLibrosNewLibro);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = editorial.getId();
                if (findEditorial(id) == null) {
                    throw new NonexistentEntityException("The editorial with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Editorial editorial;
            try {
                editorial = em.getReference(Editorial.class, id);
                editorial.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The editorial with id " + id + " no longer exists.", enfe);
            }
            List<Libro> libros = editorial.getLibros();
            for (Libro librosLibro : libros) {
                librosLibro.setEditorial(null);
                librosLibro = em.merge(librosLibro);
            }
            em.remove(editorial);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Editorial> findEditorialEntities() {
        return findEditorialEntities(true, -1, -1);
    }

    public List<Editorial> findEditorialEntities(int maxResults, int firstResult) {
        return findEditorialEntities(false, maxResults, firstResult);
    }

    private List<Editorial> findEditorialEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Editorial.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Editorial findEditorial(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Editorial.class, id);
        } finally {
            em.close();
        }
    }

    public int getEditorialCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Editorial> rt = cq.from(Editorial.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
