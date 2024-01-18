package com.example.pruebaConJpa.service;

import com.example.pruebaConJpa.model.Mascota;
import java.util.List;

public interface IMascotaService {

    public void saveMascota(Mascota masco);
    
    public void deleteMascota(Long idMascota);
    
    public Mascota findMascota(Long idMascota);
    
    public List<Mascota> getMascotas();
    
    public void editMascota(Long idMascotaOriginal, Long idMascotaNuevo, String nombreNuevo, String especieNueva, String razaNueva, String colorNuevo);

    public void editMascota(Mascota masco);
}
