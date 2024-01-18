package com.example.cursosProgramacion.service;

import com.example.cursosProgramacion.model.Tema;
import java.util.List;

public interface ITemaService {

    public void saveTema(Tema tema);
    
    public void deleteTema(Long id_tema);
    
    public Tema findTema(Long id_tema);
    
    public List<Tema> getTemas();
    
    public void editTema(Long id_tema, String nombreNuevo, String descripcionNueva);
    
    public void editTema(Tema tema);
}
