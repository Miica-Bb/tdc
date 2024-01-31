package com.example.clinica_veterinaria.service;

import com.example.clinica_veterinaria.dto.MascotaDuenioDTO;
import com.example.clinica_veterinaria.model.Mascota;
import java.util.List;

public interface IMascotaService {

    public void saveMascota(Mascota masco);
    
    public void deleteMascota(Long id_mascota);
    
    public Mascota findMascota(Long id_mascota);
    
    public List<Mascota> getMascotas();
    
    public void editMascota(Long id_mascota, String nombreNuevo, String especieNueva, String razaNueva, String colorNuevo);
    
    public void editMascota(Mascota masco);
    
    public List<Mascota> getListaPerrosCaniches();
    
    public List<MascotaDuenioDTO> getListaCombinada(); 
}
