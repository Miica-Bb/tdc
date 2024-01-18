package concesionaria.persistencia;

import concesionaria.logica.Automovil;
import concesionaria.persistencia.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladoraPersistencia {
    AutomovilJpaController autoJpa = new AutomovilJpaController();

    public void guardarAuto(Automovil auto) {
        autoJpa.create(auto);
    }
    
    public void eliminar(int id) {
        try {
            autoJpa.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarAuto(Automovil auto) {
        try {
            autoJpa.edit(auto);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Automovil> buscarListaAutos() {
        List<Automovil> autos = autoJpa.findAutomovilEntities();
        ArrayList<Automovil> listaAutos = new ArrayList<>(autos);
        return listaAutos;
    }

    public Automovil buscarAuto(int id) {
        return autoJpa.findAutomovil(id);
    }

    

    
}
