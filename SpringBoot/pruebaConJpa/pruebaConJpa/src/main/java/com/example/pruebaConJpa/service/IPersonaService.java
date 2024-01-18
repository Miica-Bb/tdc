package com.example.pruebaConJpa.service;

import com.example.pruebaConJpa.model.Persona;
import java.util.List;

public interface IPersonaService {

    public void savePersona(Persona perso);
    
    public void deletePersona(Long id);
    
    public List<Persona> getPersonas();
    
    public Persona findPersona(Long id);
    
    public void editPersona(Long idOriginal, Long idNueva, String nombreNuevo, String apellidoNuevo, int edadNueva);

    public void editPersona(Persona perso);
}
