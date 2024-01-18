package com.example.estaturas.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Jugador {
    private int id;
    private String dni;
    private String nombre;
    private String  apellido;
    private int edad;
    private double peso;
    private double altura;

    public Jugador() {
    }

    public Jugador(int id, String dni, String nombre, String apellido, int edad, double peso, double altura) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.altura = altura;
    }
}
