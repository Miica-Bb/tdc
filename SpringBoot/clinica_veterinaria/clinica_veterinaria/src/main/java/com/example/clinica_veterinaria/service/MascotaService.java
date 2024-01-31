package com.example.clinica_veterinaria.service;

import com.example.clinica_veterinaria.dto.MascotaDuenioDTO;
import com.example.clinica_veterinaria.model.Duenio;
import com.example.clinica_veterinaria.model.Mascota;
import com.example.clinica_veterinaria.repository.IMascotaRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    
    @Autowired
    IMascotaRepository mascoRepo;

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long id_mascota) {
        mascoRepo.deleteById(id_mascota);
    }

    @Override
    public Mascota findMascota(Long id_mascota) {
        return mascoRepo.findById(id_mascota).orElse(null);
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascoRepo.findAll();
    }

    @Override
    public void editMascota(Long id_mascota, String nombreNuevo, String especieNueva, String razaNueva, String colorNuevo) {
        Mascota masco = this.findMascota(id_mascota);
        
        masco.setNombre(nombreNuevo);
        masco.setEspecie(especieNueva);
        masco.setRaza(razaNueva);
        masco.setColor(colorNuevo);
        
        this.saveMascota(masco);
    }    
 
    @Override
    public void editMascota(Mascota masco) {
        this.saveMascota(masco);
    }

    @Override
    public List<Mascota> getListaPerrosCaniches() {
        String especie = "Perro";
        String raza = "Caniche";
        List<Mascota> listaPerrosCaniches = new ArrayList<>();
        List<Mascota> listaMascotas = this.getMascotas();
        
        for(Mascota masco : listaMascotas) {
            if(masco.getEspecie().equals(especie) && masco.getRaza().equals(raza)) {
                listaPerrosCaniches.add(masco);
            }
        }
        
        return listaPerrosCaniches;
    }

    @Override
    public List<MascotaDuenioDTO> getListaCombinada() {
        
        List<MascotaDuenioDTO> listaDatosMascoDuenio = new ArrayList<>();
        List<Mascota> listaMascotas = this.getMascotas();
        Duenio duenio;
        MascotaDuenioDTO mascoDue;
        
        for(Mascota masco : listaMascotas) {
            mascoDue =  new MascotaDuenioDTO();
            mascoDue.setNombre_mascota(masco.getNombre());
            mascoDue.setEspecie(masco.getEspecie());
            mascoDue.setRaza(masco.getRaza());
            duenio = masco.getUnDuenio();
            
            mascoDue.setNombre_duenio(duenio.getNombre());
            mascoDue.setApellido_duenio(duenio.getApellido());
            
            listaDatosMascoDuenio.add(mascoDue);
        }
        
        return listaDatosMascoDuenio;
    }

    
}
