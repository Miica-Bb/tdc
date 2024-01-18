package com.mycompany.biblioteca.persistencia;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.biblioteca.logica.Autor;
import com.mycompany.biblioteca.logica.Editorial;
import com.mycompany.biblioteca.logica.Libro;
import com.mycompany.biblioteca.persistencia.exceptions.NonexistentEntityException;
import com.mycompany.biblioteca.persistencia.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class LibroJpaController implements Serializable {

    public LibroJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;
    
    public LibroJpaController() {
        emf = Persistence.createEntityManagerFactory("bibliotecaPU");
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Libro libro) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Autor autor = libro.getAutor();
            if (autor != null) {
                autor = em.getReference(autor.getClass(), autor.getId());
                libro.setAutor(autor);
            }
            Editorial editorial = libro.getEditorial();
            if (editorial != null) {
                editorial = em.getReference(editorial.getClass(), editorial.getId());
                libro.setEditorial(editorial);
            }
            em.persist(libro);
            if (autor != null) {
                autor.getLibros().add(libro);
                autor = em.merge(autor);
            }
            if (editorial != null) {
                editorial.getLibros().add(libro);
                editorial = em.merge(editorial);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findLibro(libro.getIsbn()) != null) {
                throw new PreexistingEntityException("Libro " + libro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Libro libro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro persistentLibro = em.find(Libro.class, libro.getIsbn());
            Autor autorOld = persistentLibro.getAutor();
            Autor autorNew = libro.getAutor();
            Editorial editorialOld = persistentLibro.getEditorial();
            Editorial editorialNew = libro.getEditorial();
            if (autorNew != null) {
                autorNew = em.getReference(autorNew.getClass(), autorNew.getId());
                libro.setAutor(autorNew);
            }
            if (editorialNew != null) {
                editorialNew = em.getReference(editorialNew.getClass(), editorialNew.getId());
                libro.setEditorial(editorialNew);
            }
            libro = em.merge(libro);
            if (autorOld != null && !autorOld.equals(autorNew)) {
                autorOld.getLibros().remove(libro);
                autorOld = em.merge(autorOld);
            }
            if (autorNew != null && !autorNew.equals(autorOld)) {
                autorNew.getLibros().add(libro);
                autorNew = em.merge(autorNew);
            }
            if (editorialOld != null && !editorialOld.equals(editorialNew)) {
                editorialOld.getLibros().remove(libro);
                editorialOld = em.merge(editorialOld);
            }
            if (editorialNew != null && !editorialNew.equals(editorialOld)) {
                editorialNew.getLibros().add(libro);
                editorialNew = em.merge(editorialNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                long id = libro.getIsbn();
                if (findLibro(id) == null) {
                    throw new NonexistentEntityException("The libro with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Libro libro;
            try {
                libro = em.getReference(Libro.class, id);
                libro.getIsbn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The libro with id " + id + " no longer exists.", enfe);
            }
            Autor autor = libro.getAutor();
            if (autor != null) {
                autor.getLibros().remove(libro);
                autor = em.merge(autor);
            }
            Editorial editorial = libro.getEditorial();
            if (editorial != null) {
                editorial.getLibros().remove(libro);
                editorial = em.merge(editorial);
            }
            em.remove(libro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Libro> findLibroEntities() {
        return findLibroEntities(true, -1, -1);
    }

    public List<Libro> findLibroEntities(int maxResults, int firstResult) {
        return findLibroEntities(false, maxResults, firstResult);
    }

    private List<Libro> findLibroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Libro.class));
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

    public Libro findLibro(long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Libro.class, id);
        } finally {
            em.close();
        }
    }

    public int getLibroCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Libro> rt = cq.from(Libro.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
