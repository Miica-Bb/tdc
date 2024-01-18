package com.example.areaTriangulo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class appController {
    
    @GetMapping("/calcularArea/triangulo")
    public String calcularAreaTriangulo (@RequestParam double base, @RequestParam double altura) {
        double area = (base * altura) / 2;
        
        return "para las medidas ingresadas, el área del triángulo es: " + area;
    }
}
