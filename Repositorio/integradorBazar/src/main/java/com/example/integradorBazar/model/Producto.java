package com.example.integradorBazar.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id_producto;
    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;
    @ManyToMany(mappedBy = "listaProductos")
    private List<Venta> listaVentas;

    public Producto() {
    }

    public Producto(Long id_producto, String nombre, String marca, Double costo, Double cantidad_disponible, List<Venta> listaVentas) {
        this.id_producto = id_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.listaVentas = listaVentas;
    }
}
