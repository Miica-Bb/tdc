package com.example.ejclasedto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PropiedadDTO {
    private int id_propiedad;
    private String tipo;
    private String direccion;
    private double valor_alquiler;
    private String nombre_inquilino;
    private String apellido_inquilino;

    public PropiedadDTO() {
    }

    public PropiedadDTO(int id_propiedad, String tipo, String direccion, double valor_alquiler, String nombre_inquilino, String apellido_inquilino) {
        this.id_propiedad = id_propiedad;
        this.tipo = tipo;
        this.direccion = direccion;
        this.valor_alquiler = valor_alquiler;
        this.nombre_inquilino = nombre_inquilino;
        this.apellido_inquilino = apellido_inquilino;
    }
}
