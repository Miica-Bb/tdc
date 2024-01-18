package com.mycompany.mascotas.persistencia;

import com.mycompany.mascotas.logica.Perro;
import com.mycompany.mascotas.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    PerroJpaController perroJpa = new PerroJpaController();
    
    public void crearPerro(Perro perro) {
        perroJpa.create(perro);
    }

    public void eliminarPerro(int id) {
        try {
            perroJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarPerro(Perro perro) {
        try {
            perroJpa.edit(perro);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Perro buscarPerro(int id) {
        return perroJpa.findPerro(id);
    }
    
    public ArrayList<Perro> buscarTotalPerros() {
        List<Perro> listaPerros = perroJpa.findPerroEntities();
        ArrayList<Perro> arrayPerros = new ArrayList<> (listaPerros);
        
        return arrayPerros;
    }
}
