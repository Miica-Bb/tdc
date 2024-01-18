package com.example.ejclasedto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Propiedad {
    private int id_propiedad;
    private String tipo;
    private String direccion;
    private double metros_cuadrados;
    private double valor_alquiler;

    public Propiedad() {
    }

    public Propiedad(int id_propiedad, String tipo, String direccion, double metros_cuadrados, double valor_alquiler) {
        this.id_propiedad = id_propiedad;
        this.tipo = tipo;
        this.direccion = direccion;
        this.metros_cuadrados = metros_cuadrados;
        this.valor_alquiler = valor_alquiler;
    }
}
