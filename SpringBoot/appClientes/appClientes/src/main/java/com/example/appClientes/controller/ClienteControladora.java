package com.example.appClientes.controller;

import com.example.appClientes.Cliente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteControladora {
    
    @PostMapping("/nuevoCliente")
    public void crearCliente(@RequestBody Cliente cli) {
        System.out.println("Nuevo cliente creado exitosamente");
        System.out.println("Nombre: " + cli.getNombre());
        System.out.println("Apellido: " + cli.getApellido());
    }
}
