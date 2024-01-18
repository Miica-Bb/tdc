package com.mycompany.biblioteca.persistencia;

import com.mycompany.biblioteca.logica.Autor;
import com.mycompany.biblioteca.logica.Editorial;
import com.mycompany.biblioteca.logica.Libro;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    LibroJpaController libroJpa = new LibroJpaController();
    AutorJpaController autorJpa = new AutorJpaController();
    EditorialJpaController editorialJpa = new EditorialJpaController();

    //métodos editorial
    public void guardarEditorial(Editorial edito) {
        editorialJpa.create(edito);
    }

    public List<Editorial> buscarListaEditoriales() {
        return editorialJpa.findEditorialEntities();
    }
    
    public void editarEditorial(Editorial edito) {
        try {
            editorialJpa.edit(edito);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //métodos autor
    public void guardarAutor(Autor autor) {
        autorJpa.create(autor);
    }
    
    public List<Autor> buscarListaAutores() {
        return autorJpa.findAutorEntities();
    }

    public void editarAutor(Autor autor) {
        try {
            autorJpa.edit(autor);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //métodos libro
    public void guardarLibro(Libro libro) throws Exception {
        libroJpa.create(libro);
    }

    
}
