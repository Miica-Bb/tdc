package com.example.clinica_veterinaria.service;

import com.example.clinica_veterinaria.model.Duenio;
import com.example.clinica_veterinaria.repository.IDuenioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuenioService implements IDuenioService {
    
    @Autowired
    IDuenioRepository duenioRepo;

    @Override
    public void saveDuenio(Duenio duenio) {
        duenioRepo.save(duenio);
    }

    @Override
    public void deleteDuenio(Long id_duenio) {
        duenioRepo.deleteById(id_duenio);
    }

    @Override
    public Duenio findDuenio(Long id_duenio) {
        return duenioRepo.findById(id_duenio).orElse(null);
    }

    @Override
    public List<Duenio> getDuenios() {
        return duenioRepo.findAll();
    }

    @Override
    public void editDuenio(Long id_duenio, String dniNuevo, String nombreNuevo, String apellidoNuevo, String celularNuevo) {
        Duenio duenio = this.findDuenio(id_duenio);
        
        duenio.setNombre(nombreNuevo);
        duenio.setApellido(apellidoNuevo);
        duenio.setDni(dniNuevo);
        duenio.setCelular(celularNuevo);
        
        this.saveDuenio(duenio);
    }

    @Override
    public void editDuenio(Duenio duenio) {
        this.saveDuenio(duenio);
    }
}
