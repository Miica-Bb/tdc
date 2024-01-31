package com.example.clinica_veterinaria.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Mascota {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_mascota;
    private String nombre;
    private String especie;
    private String raza;
    private String color;
    @ManyToOne
    @JoinColumn (name = "fk_duenio")
    @JsonIgnore
    private Duenio unDuenio;

    public Mascota() {
    }

    public Mascota(Long id_mascota, String nombre, String especie, String raza, String color, Duenio unDuenio) {
        this.id_mascota = id_mascota;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.color = color;
        this.unDuenio = unDuenio;
    }
}
