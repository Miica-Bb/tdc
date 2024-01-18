package com.example.pruebaConJpa.repository;

import com.example.pruebaConJpa.model.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMascotaRepository extends JpaRepository <Mascota, Long> {

}
