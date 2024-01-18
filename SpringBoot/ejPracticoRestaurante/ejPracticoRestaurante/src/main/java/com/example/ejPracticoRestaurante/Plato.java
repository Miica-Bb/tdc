package com.example.ejPracticoRestaurante;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Plato {
    private int numPlato;
    private String nombre;
    private double precio;
    private String descripcion;

    public Plato() {
    }

    public Plato(int numPlato, String nombre, double precio, String descripcion) {
        this.numPlato = numPlato;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }
    
}
