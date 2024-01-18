package com.example.cursosProgramacion.service;

import com.example.cursosProgramacion.model.Tema;
import com.example.cursosProgramacion.repository.ITemaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemaService implements ITemaService {

    @Autowired
    ITemaRepository temaRepo;
    
    @Override
    public void saveTema(Tema tema) {
        temaRepo.save(tema);
    }

    @Override
    public void deleteTema(Long id_tema) {
        temaRepo.deleteById(id_tema);
    }

    @Override
    public Tema findTema(Long id_tema) {
        return temaRepo.findById(id_tema).orElse(null);
    }

    @Override
    public List<Tema> getTemas() {
        return temaRepo.findAll();
    }

    @Override
    public void editTema(Long id_tema, String nombreNuevo, String descripcionNueva) {
        Tema tema = this.findTema(id_tema);
        
        tema.setNombre(nombreNuevo);
        tema.setDescripcion(descripcionNueva);
        
        this.saveTema(tema);
    }

    @Override
    public void editTema(Tema tema) {
        this.saveTema(tema);
    }
    
}
