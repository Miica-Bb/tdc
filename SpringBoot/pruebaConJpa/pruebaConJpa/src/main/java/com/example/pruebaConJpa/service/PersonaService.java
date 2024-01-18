package com.example.pruebaConJpa.service;

import com.example.pruebaConJpa.model.Persona;
import com.example.pruebaConJpa.repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonaService implements IPersonaService {
    
    @Autowired
    private IPersonaRepository persoRepo;

    @Override
    public void savePersona(Persona perso) {
        persoRepo.save(perso);
    }

    @Override
    public void deletePersona(Long id) {
        persoRepo.deleteById(id);
    }

    @Override
    public List<Persona> getPersonas() {
        return persoRepo.findAll();
    }

    @Override
    public Persona findPersona(Long id) {
        return persoRepo.findById(id).orElse(null);
    }

    @Override
    public void editPersona(Long idOriginal, Long idNueva, String nombreNuevo, String apellidoNuevo, int edadNueva) {
        Persona perso = this.findPersona(idOriginal);
        
        perso.setId(idNueva);
        perso.setNombre(nombreNuevo);
        perso.setApellido(apellidoNuevo);
        perso.setEdad(edadNueva);
        
        this.savePersona(perso);
    }

    @Override
    public void editPersona(Persona perso) {
        this.savePersona(perso);
    }
}
