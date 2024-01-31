package com.example.clinica_veterinaria.controller;

import com.example.clinica_veterinaria.model.Duenio;
import com.example.clinica_veterinaria.service.IDuenioService;
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
public class DuenioController {
    
    @Autowired
    IDuenioService duenioServ;
    
    @GetMapping("/dueño/encontrar/{id_duenio}")
    public Duenio findDuenio(@PathVariable Long id_duenio) {
        return duenioServ.findDuenio(id_duenio);
    }
    
    @GetMapping("/dueño/traerTodos")
    public List<Duenio> getDuenios() {
        return duenioServ.getDuenios();
    }
    
    @PostMapping("/dueño/guardar")
    public void saveDuenio(@RequestBody Duenio duenio) {
        duenioServ.saveDuenio(duenio);
    }
    
    @DeleteMapping("/dueño/eliminar/{id_duenio}")
    public void deleteDuenio(@PathVariable Long id_duenio) {
        duenioServ.deleteDuenio(id_duenio);
    }
    
    @PutMapping("/dueño/editar/{id_duenio}")
    public void editDuenio(@PathVariable Long id_duenio, 
            @RequestParam (required = false, name = "dni") String dniNuevo, 
            @RequestParam (required = false, name = "nombre") String nombreNuevo, 
            @RequestParam (required = false, name = "apellido") String apellidoNuevo, 
            @RequestParam (required = false, name = "celular") String celularNuevo) {
        
        duenioServ.editDuenio(id_duenio, dniNuevo, nombreNuevo, apellidoNuevo, celularNuevo);
    }
    
    @PutMapping("/dueño/editar")
    public void editDuenio(@RequestBody Duenio duenio) {
        duenioServ.editDuenio(duenio);
    }
}
