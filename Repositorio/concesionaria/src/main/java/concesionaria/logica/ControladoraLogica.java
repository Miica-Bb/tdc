package concesionaria.logica;

import concesionaria.persistencia.ControladoraPersistencia;
import java.util.ArrayList;

public class ControladoraLogica {
    ControladoraPersistencia controlP = new ControladoraPersistencia();

    public void guardarAuto(String modelo, String marca, String motor, String color, String patente, String cantPuertas) {
        Automovil auto = new Automovil();
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantidadPuertas(cantPuertas);
        
        controlP.guardarAuto(auto);
    }
    
    public void eliminar(int id) {
        controlP.eliminar(id);
    }
    
    public void editarAuto(Automovil auto, String modelo, String marca, String motor, String color, String patente, String cantPuertas) {
        auto.setModelo(modelo);
        auto.setMarca(marca);
        auto.setMotor(motor);
        auto.setColor(color);
        auto.setPatente(patente);
        auto.setCantidadPuertas(cantPuertas);
        
        controlP.editarAuto(auto);
    }

    public Automovil buscarAuto(int id) {
        return controlP.buscarAuto(id);
    }
    
    public ArrayList<Automovil> buscarListaAutos() {
        return controlP.buscarListaAutos();
    }

    

    
}
