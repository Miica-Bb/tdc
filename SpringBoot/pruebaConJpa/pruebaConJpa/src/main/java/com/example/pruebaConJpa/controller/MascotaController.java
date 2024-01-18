package com.example.pruebaConJpa.controller;

import com.example.pruebaConJpa.model.Mascota;
import com.example.pruebaConJpa.service.IMascotaService;
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
    public String saveMascota(@RequestBody Mascota masco) {
        mascoServ.saveMascota(masco);
        
        return "Mascota guardada correctamente";
    }
    
    @DeleteMapping("/mascota/eliminar/{idMascota}")
    public String deleteMascota(@PathVariable Long idMascota) {
        mascoServ.deleteMascota(idMascota);
        
        return "Mascota eliminada correctamente";
    }
    
    @GetMapping("/mascota/encontrar/{idMascota}")
    public Mascota findMascota(@PathVariable Long idMascota) {
        return mascoServ.findMascota(idMascota);
    }
    
    @GetMapping("/mascota/traerTodas")
    public List<Mascota> getMascotas() {
        return mascoServ.getMascotas();
    }
    
    @PutMapping("/mascota/editar/{idMascotaOriginal}")
    public Mascota editMascota(@PathVariable Long idMascotaOriginal, 
            @RequestParam(required = false, name = "idMascota") Long idMascotaNueva,
            @RequestParam(required = false, name = "nombre") String nombreNuevo,
            @RequestParam(required = false, name = "especie") String especieNueva,
            @RequestParam(required = false, name = "raza") String razaNueva,
            @RequestParam(required = false, name = "color") String colorNuevo) {
        
        mascoServ.editMascota(idMascotaOriginal, idMascotaNueva, nombreNuevo, especieNueva, razaNueva, colorNuevo);
        Mascota masco = mascoServ.findMascota(idMascotaOriginal);
    
        return masco;
    }
    
    @PutMapping("/mascota/editar")
    public Mascota editMascota(@RequestBody Mascota masco) {
        mascoServ.editMascota(masco);
        
        return mascoServ.findMascota(masco.getIdMascota());
    }
}
