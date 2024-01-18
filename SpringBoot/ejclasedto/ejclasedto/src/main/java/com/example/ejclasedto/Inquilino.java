package com.example.ejclasedto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Inquilino {
    private int id_inquilino;
    private String nombre;
    private String apellido;
    private String dni;
    private String profesion;

    public Inquilino() {
    }

    public Inquilino(int id_inquilino, String nombre, String apellido, String dni, String profesion) {
        this.id_inquilino = id_inquilino;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.profesion = profesion;
    }
}
