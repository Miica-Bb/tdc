package com.example.pruebaConJpa.service;

import com.example.pruebaConJpa.model.Mascota;
import com.example.pruebaConJpa.repository.IMascotaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MascotaService implements IMascotaService {
    @Autowired
    IMascotaRepository mascoRepo;

    @Override
    public void saveMascota(Mascota masco) {
        mascoRepo.save(masco);
    }

    @Override
    public void deleteMascota(Long idMascota) {
        mascoRepo.deleteById(idMascota);
    }

    @Override
    public Mascota findMascota(Long idMascota) {
        return mascoRepo.findById(idMascota).orElse(null);
    }

    @Override
    public List<Mascota> getMascotas() {
        return mascoRepo.findAll();
    }

    @Override
    public void editMascota(Long idMascotaOriginal, Long idMascotaNuevo, String nombreNuevo, String especieNueva, String razaNueva, String colorNuevo) {
        Mascota masco = this.findMascota(idMascotaOriginal);
        
        masco.setIdMascota(idMascotaNuevo);
        masco.setNombre(nombreNuevo);
        masco.setEspecie(especieNueva);
        masco.setRaza(razaNueva);
        masco.setColor(colorNuevo);
        
        this.saveMascota(masco);
    }

    @Override
    public void editMascota(Mascota masco) {
        this.saveMascota(masco);
    }
}
