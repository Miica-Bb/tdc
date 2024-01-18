package com.example.cursosProgramacion.controller;

import com.example.cursosProgramacion.model.Tema;
import com.example.cursosProgramacion.service.ITemaService;
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
public class TemaController {
    
    @Autowired
    ITemaService temaServ;
    
    @PostMapping("/tema/guardar")
    public String guardarTema(@RequestBody Tema tema) {
        temaServ.saveTema(tema);
        
        return "Tema creado exitosamente";
    }
    
    @DeleteMapping("/tema/borrar/{id_tema}")
    public String borrarTema(@PathVariable Long id_tema) {
        temaServ.deleteTema(id_tema);
        
        return "tema eliminado exitosamente";
    }
    
    @GetMapping("/tema/buscar/{id_tema}")
    public Tema buscarTema(@PathVariable Long id_tema) {
        return temaServ.findTema(id_tema);
    }
    
    @GetMapping("/tema/traerTodos")
    public List<Tema> traerTemas() {
        return temaServ.getTemas();
    }
    
    @PutMapping("/tema/editar/{id_tema}")
    public String editarTema(@PathVariable Long id_tema, 
            @RequestParam (required = false, name = "nombre") String nombreNuevo, 
            @RequestParam (required = false, name = "descripcion") String descripcionNueva) {
        
        temaServ.editTema(id_tema, nombreNuevo, descripcionNueva);
        
        return "datos del tema editados con éxito";
    }
    
    @PutMapping("/tema/editar")
    public String editarTema(@RequestBody Tema tema) {
        temaServ.editTema(tema);
        
        return "datos del tema editados con éxito";
    }
}
