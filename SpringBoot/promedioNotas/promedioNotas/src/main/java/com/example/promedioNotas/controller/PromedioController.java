package com.example.promedioNotas.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PromedioController {
    
    @GetMapping("/promedio")
    public String calcularPromedio(@RequestParam double notaUno, @RequestParam double notaDos, @RequestParam double notaTres) {
        double promedio = (notaUno + notaDos + notaTres) / 3;
        String mensaje = "A partir de las notas ingresadas, el promedio es: " + promedio;
        
        return mensaje;
    }
}
