package com.example.clinica_veterinaria.service;

import com.example.clinica_veterinaria.model.Duenio;
import java.util.List;

public interface IDuenioService {

    public void saveDuenio(Duenio duenio);
    
    public void deleteDuenio(Long id_duenio);
    
    public Duenio findDuenio(Long id_duenio);
    
    public List<Duenio> getDuenios();
    
    public void editDuenio(Long id_duenio, String dniNuevo, String nombreNuevo, String apellidoNuevo, String celularNuevo);
    
    public void editDuenio(Duenio duenio);
}
