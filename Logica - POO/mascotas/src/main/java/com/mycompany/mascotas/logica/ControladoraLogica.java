package com.mycompany.mascotas.logica;

import com.mycompany.mascotas.persistencia.ControladoraPersistencia;
import java.util.ArrayList;

public class ControladoraLogica {
    ControladoraPersistencia controlP = new ControladoraPersistencia();
    
    public void crearPerro(Perro perro) {
        controlP.crearPerro(perro);
    }
    
    public void eliminarPerro(int id) {
        controlP.eliminarPerro(id);
    }
    
    public void editarPerro(Perro perro) {
        controlP.editarPerro(perro);
    }
    
    public Perro buscarPerro(int id) {
        return controlP.buscarPerro(id);
    }
    
    public ArrayList<Perro> buscarTotalPerros() {
        return controlP.buscarTotalPerros();
    }
}
