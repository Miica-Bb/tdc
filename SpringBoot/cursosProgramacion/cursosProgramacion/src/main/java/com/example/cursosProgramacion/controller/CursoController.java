package com.example.cursosProgramacion.controller;

import com.example.cursosProgramacion.dto.CursoTemaDTO;
import com.example.cursosProgramacion.model.Curso;
import com.example.cursosProgramacion.service.ICursoService;
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
public class CursoController {
    
    @Autowired
    ICursoService curServ;
    
    @PostMapping("/curso/crear")
    public String crearCurso(@RequestBody Curso cur) {
        curServ.saveCurso(cur);
        
        return "Curso creado con éxito";
    }
    
    @DeleteMapping("/curso/eliminar/{id_curso}")
    public String eliminarCurso(@PathVariable Long id_curso) {
        curServ.deleteCurso(id_curso);
        
        return "Curso eliminado exitosamente";
    }
    
    @GetMapping("/curso/buscar/{id_curso}")
    public Curso buscarCurso(@PathVariable Long id_curso) {
        return curServ.findCurso(id_curso);
    }
    
    @GetMapping("/curso/traerTodos")
    public List<Curso> traerCursos() {
        return curServ.getCursos();
    }
    
    @PutMapping("/curso/editar/{id_curso}")
    public String editarCurso(@PathVariable Long id_curso, 
            @RequestParam (required = false, name = "nombre") String nombreNuevo, 
            @RequestParam (required = false, name = "modalidad") String modalidadNueva, 
            @RequestParam (required = false, name = "fecha_finalizacion") String fechaFinalizacionNueva) {
        
        curServ.editCurso(id_curso, nombreNuevo, modalidadNueva, fechaFinalizacionNueva);
        
        return "Datos del curso editados correctamente";
    }
    
    @PutMapping("/curso/editar")
    public String editarCurso(@RequestBody Curso cur) {
        curServ.editCurso(cur);
        
        return "Datos del curso editados correctamente";
    }
    
    @GetMapping("/curso/temas/{id_curso}")
    public CursoTemaDTO traerTemasPorCurso(@PathVariable Long id_curso) {
        return curServ.getTemasPorCurso(id_curso);
    }
    
    @GetMapping("/curso/java")
    public List<Curso> traerCursosJava() {
        return curServ.getCursosJava();
    }
}
