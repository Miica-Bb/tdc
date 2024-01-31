package com.example.clinica_veterinaria.controller;

import com.example.clinica_veterinaria.dto.MascotaDuenioDTO;
import com.example.clinica_veterinaria.model.Mascota;
import com.example.clinica_veterinaria.service.IMascotaService;
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
public class MascotaController {
    
    @Autowired
    IMascotaService mascoServ;
    
    @PostMapping("/mascota/guardar")
    public void saveMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
    }
    
    @DeleteMapping("/mascota/eliminar/{id_mascota}")
    public void deleteMascota(@PathVariable Long id_mascota) {
        mascoServ.deleteMascota(id_mascota);
    }
    
    @GetMapping("/mascota/encontrar/{id_mascota}")
    public Mascota findMascota(@PathVariable Long id_mascota) {
        return mascoServ.findMascota(id_mascota);
    }
    
    @GetMapping("/mascota/traerTodas")
    public List<Mascota> getMascotas() {
        return mascoServ.getMascotas();
    }
    
    @PutMapping("/mascota/editar/{id_mascota}")
    public void editMascota(@PathVariable Long id_mascota, 
            @RequestParam (required = false, name = "nombre") String nombreNuevo, 
            @RequestParam (required = false, name = "especie") String especieNueva, 
            @RequestParam (required = false, name = "raza") String razaNueva, 
            @RequestParam (required = false, name = "color") String colorNuevo) {
        
        mascoServ.editMascota(id_mascota, nombreNuevo, especieNueva, razaNueva, colorNuevo);
    }
    
    @PutMapping("/mascota/editar")
    public void editMascota(@RequestBody Mascota masco) {
        mascoServ.editMascota(masco);
    }
    
    @GetMapping("/mascota/perros/caniches")
    public List<Mascota> getListaPerrosCaniches() {
        return mascoServ.getListaPerrosCaniches();
    }
    
    @GetMapping("/mascota/dueño/datos")
    public List<MascotaDuenioDTO> getListaCombinada() {
        return mascoServ.getListaCombinada();
    }
}
