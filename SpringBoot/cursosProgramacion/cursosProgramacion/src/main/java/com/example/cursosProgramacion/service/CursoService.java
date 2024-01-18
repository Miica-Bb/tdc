package com.example.cursosProgramacion.service;

import com.example.cursosProgramacion.dto.CursoTemaDTO;
import com.example.cursosProgramacion.model.Curso;
import com.example.cursosProgramacion.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService implements ICursoService {

    @Autowired
    ICursoRepository cursoRepo;
    
    @Override
    public void saveCurso(Curso cur) {
        cursoRepo.save(cur);
    }

    @Override
    public void deleteCurso(Long id_curso) {
        cursoRepo.deleteById(id_curso);
    }

    @Override
    public Curso findCurso(Long id_curso) {
        return cursoRepo.findById(id_curso).orElse(null);
    }

    @Override
    public List<Curso> getCursos() {
        return cursoRepo.findAll();
    }

    @Override
    public void editCurso(Long id_curso, String nombreNuevo, String modalidadNueva, String fechaFinalizacionNueva) {
        Curso cur = this.findCurso(id_curso);
        
        cur.setNombre(nombreNuevo);
        cur.setModalidad(modalidadNueva);
        cur.setFecha_finalizacion(fechaFinalizacionNueva);
        
        this.saveCurso(cur);
    }

    @Override
    public void editCurso(Curso cur) {
        this.saveCurso(cur);
    }

    @Override
    public CursoTemaDTO getTemasPorCurso(Long id_curso) {
        CursoTemaDTO curTemDTO = new CursoTemaDTO();
        Curso cur = this.findCurso(id_curso);
        
        curTemDTO.setNombreCurso(cur.getNombre());
        curTemDTO.setListaTemas(cur.getListaDeTemas());
        
        return curTemDTO;
    }

    @Override
    public List<Curso> getCursosJava() {
        String palabraClave = "Java";
        
        List<Curso> listaCursosJava = new ArrayList<>();
        List<Curso> listaCursos = this.getCursos();
        
        for(Curso cur : listaCursos) {
            if(cur.getNombre().contains(palabraClave)) {
                listaCursosJava.add(cur);
            }
        }
        
        return listaCursosJava;
    }
    
}
