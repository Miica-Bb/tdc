package peluqueriacanina.persistencia;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import peluqueriacanina.logica.Duenio;
import peluqueriacanina.logica.Mascota;
import peluqueriacanina.persistencia.exceptions.NonexistentEntityException;

public class ControladoraPersistencia {
    DuenioJpaController duenioJpa = new DuenioJpaController();
    MascotaJpaController mascotaJpa = new MascotaJpaController();

    //métodos mascota
    public void eliminarMascota(int num_cliente) {
        try {
            mascotaJpa.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void editarMascota(Mascota mascota) {
        try {
            mascotaJpa.edit(mascota);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Mascota buscarMascota(int num_cliente) {
        return mascotaJpa.findMascota(num_cliente);
    }
    
    public ArrayList<Mascota> buscarListaMascotas() {
        List<Mascota> listaMascotas = mascotaJpa.findMascotaEntities();
        ArrayList<Mascota> arrayListMascotas = new ArrayList<>(listaMascotas);
        return arrayListMascotas;
    }

    //métodos dueño
    public void eliminarDuenio(int id_duenio) {
        try {
            duenioJpa.destroy(id_duenio);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void editarDuenio(Duenio duenio) {
        try {
            duenioJpa.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio buscarDuenio(int id_duenio) {
        return duenioJpa.findDuenio(id_duenio);
    }

    public ArrayList<Duenio> buscarListaDuenios() {
        List<Duenio> listaDuenios = duenioJpa.findDuenioEntities();
        ArrayList<Duenio> ArrayListDuenios = new ArrayList<>(listaDuenios);
        return ArrayListDuenios;
    }

    //guardar en BDD ambos objetos
    public void guardar(Mascota perro, Duenio duenio) {
        duenioJpa.create(duenio);
        mascotaJpa.create(perro);
    }
}
