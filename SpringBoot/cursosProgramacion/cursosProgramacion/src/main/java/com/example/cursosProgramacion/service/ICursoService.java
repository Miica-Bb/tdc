package com.example.cursosProgramacion.service;

import com.example.cursosProgramacion.dto.CursoTemaDTO;
import com.example.cursosProgramacion.model.Curso;
import java.util.List;

public interface ICursoService {

    public void saveCurso(Curso cur);
    
    public void deleteCurso(Long id_curso);
    
    public Curso findCurso(Long id_curso);
    
    public List<Curso> getCursos();
    
    public void editCurso(Long id_curso, String nombreNuevo, String modalidadNueva, String fechaFinalizacionNueva);
    
    public void editCurso(Curso cur);
    
    public CursoTemaDTO getTemasPorCurso(Long id_curso);
    
    public List<Curso> getCursosJava();
}
