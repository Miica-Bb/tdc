package com.example.pruebaConJpa.controller;

import com.example.pruebaConJpa.model.Persona;
import com.example.pruebaConJpa.service.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonaController {
    @Autowired
    private IPersonaService persoServ;
    
    @PostMapping("/persona/guardar")
    public String savePersona(@RequestBody Persona perso) {
        persoServ.savePersona(perso);
        
        return "Persona guardada correctamente";
    }
    
    @DeleteMapping("/persona/eliminar/{id}")
    public String deletePersona(@PathVariable Long id) {
        persoServ.deletePersona(id);
        
        return "Persona eliminada correctamente";
    }
    
    @GetMapping("/persona/traerTodas")
    public List<Persona> getPersonas() {
        return persoServ.getPersonas();
    }
    
    @GetMapping("/persona/encontrar/{id}")
    public Persona findPersona(@PathVariable Long id) {
        return persoServ.findPersona(id);
    }
    
    @PutMapping("/persona/editar/{idOriginal}")
    public Persona editPersona(@PathVariable Long idOriginal, 
            @RequestParam(required = false, name = "id") Long idNueva,
            @RequestParam(required = false, name = "nombre") String nombreNuevo,
            @RequestParam(required = false, name = "apellido") String apellidoNuevo,
            @RequestParam(required = false, name = "edad") int edadNueva) {
        
        persoServ.editPersona(idOriginal, idNueva, nombreNuevo, apellidoNuevo, edadNueva);
        Persona perso = persoServ.findPersona(idNueva);
    
        return perso;
    }
    
    @PutMapping("/persona/editar")
    public Persona editPersona(@RequestBody Persona perso) {
        persoServ.editPersona(perso);
        
        return persoServ.findPersona(perso.getId());
    }
}
