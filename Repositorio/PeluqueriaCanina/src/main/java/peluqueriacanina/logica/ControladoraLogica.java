package peluqueriacanina.logica;

import java.util.ArrayList;
import peluqueriacanina.persistencia.ControladoraPersistencia;

public class ControladoraLogica {
    ControladoraPersistencia controlP = new ControladoraPersistencia();
    
    //métodos mascota    
    public void eliminarMascota(int num_cliente) {
        controlP.eliminarMascota(num_cliente);
    }
    
    public Mascota buscarMascota(int num_cliente) {
        return controlP.buscarMascota(num_cliente);
    }
    
    public ArrayList<Mascota> buscarListaMascotas() {
        return controlP.buscarListaMascotas();
    }
    
    //métodos dueño
    public Duenio buscarDuenio(int id_duenio) {
        return controlP.buscarDuenio(id_duenio);
    }
    
    public ArrayList<Duenio> buscarListaDuenios() {
        return controlP.buscarListaDuenios();
    }
    
    //métodos igu
    public void guardar(String nombreMascota, String raza, String color, String alergico, String atEsp, String observaciones,
            String nombreDuenio, String celular, String direccion) {
        
        Duenio duenio = new Duenio();
        duenio.setNombre_duenio(nombreDuenio);
        duenio.setCelular(celular);
        duenio.setDireccion(direccion);
        
        Mascota perro = new Mascota();
        perro.setNombre_perro(nombreMascota);
        perro.setColor(color);
        perro.setRaza(raza);
        perro.setAtencion_especial(atEsp);
        perro.setEsAlergico(alergico);
        perro.setObservaciones(observaciones);
        perro.setDuenio(duenio);
        
        controlP.guardar(perro, duenio);
    }

    public void modificar(Mascota masco, String nombreMascota, String raza, String color, String alergico, String atEsp, String observaciones,
            String nombreDuenio, String celular, String direccion) {
        
        Duenio duenio = this.buscarDuenio(masco.getDuenio().getId_duenio());
        duenio.setNombre_duenio(nombreDuenio);
        duenio.setCelular(celular);
        duenio.setDireccion(direccion);
        
        masco.setNombre_perro(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setAtencion_especial(atEsp);
        masco.setEsAlergico(alergico);
        masco.setObservaciones(observaciones);
        masco.setDuenio(duenio);
        
        controlP.editarDuenio(duenio);
        controlP.editarMascota(masco);
    }
}
