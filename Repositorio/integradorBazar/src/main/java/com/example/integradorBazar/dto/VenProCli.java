package com.example.integradorBazar.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VenProCli {
    private Long id_venta;
    private Double total;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;

    public VenProCli() {
    }

    public VenProCli(Long id_venta, Double total, int cantidad_productos, String nombre_cliente, String apellido_cliente) {
        this.id_venta = id_venta;
        this.total = total;
        this.cantidad_productos = cantidad_productos;
        this.nombre_cliente = nombre_cliente;
        this.apellido_cliente = apellido_cliente;
    }
}
