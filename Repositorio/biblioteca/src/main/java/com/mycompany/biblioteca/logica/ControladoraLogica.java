package com.mycompany.biblioteca.logica;

import com.mycompany.biblioteca.persistencia.ControladoraPersistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraLogica {

    ControladoraPersistencia controlP = new ControladoraPersistencia();

    public void guardar(long isbn, String titulo, int anioPublicacion, int totalEjemplares, String nombreAutor, String nombreEditorial) {
        Editorial edito = new Editorial();
        List<Libro> librosEditorial = new ArrayList();
        if(this.buscarEditorialPorNombre(nombreEditorial) != null) {
            edito = this.buscarEditorialPorNombre(nombreEditorial);
            librosEditorial = edito.getLibros();
        }

        if(edito.getNombre() == null) {
            edito.setNombre(nombreEditorial);
            edito.setLibros(librosEditorial);
            controlP.guardarEditorial(edito);
        } 
        
        Autor autor = new Autor();
        List<Libro> librosAutor = new ArrayList();
        if(this.buscarAutorPorNombre(nombreAutor) != null) {
            autor = this.buscarAutorPorNombre(nombreAutor);
            librosAutor = autor.getLibros();
        }
        
        if(autor.getNombre() == null) {
            autor.setNombre(nombreAutor);
            autor.setLibros(librosAutor);
            controlP.guardarAutor(autor);
        } 

        Libro libro = new Libro();
        libro.setIsbn(isbn);
        libro.setTitulo(titulo);
        libro.setAnioPublicacion(anioPublicacion);
        libro.setTotalEjemplares(totalEjemplares);
        libro.setEditorial(edito);
        libro.setAutor(autor);
        
        librosAutor.add(libro);
        librosEditorial.add(libro);
        autor.setLibros(librosAutor);
        edito.setLibros(librosEditorial);
        
        controlP.editarAutor(autor);
        controlP.editarEditorial(edito);
        
        try {
            controlP.guardarLibro(libro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraLogica.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Autor buscarAutorPorNombre(String nombreAutor) {
        List<Autor> listaAutores = controlP.buscarListaAutores();

        if (listaAutores != null) {
            for (Autor au : listaAutores) {
                if (au.getNombre().equals(nombreAutor)) {
                    return au;
                }
            }
        }

        return null;
    }

    private Editorial buscarEditorialPorNombre(String nombreEditorial) {
        List<Editorial> listaEditoriales = controlP.buscarListaEditoriales();
        
        if(listaEditoriales != null) {
            for(Editorial ed : listaEditoriales) {
                if(ed.getNombre().equals(nombreEditorial)) {
                    return ed;
                }
            }
        }
        
        return null;
    }
}
