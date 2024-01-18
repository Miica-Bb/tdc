package com.example.primerIntegrador.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConversorController {
    @GetMapping("/conversorGAL/{cantGalones}")
    public String convertirGalonesALitros(@PathVariable double cantGalones) {
        double cantLitros = cantGalones * 3.78541;
        
        return "Para cargar " + cantGalones + " galones, debe pedir " + cantLitros + " litros";
    }
    
    @GetMapping("/conversorLAG")
    public String convertirLitrosAGalones(@RequestParam double cantLitros) {
        double cantGalones = cantLitros / 3.78541;
        return "Para cargar " + cantLitros + " litros, debe pedir " + cantGalones + " galones";
    }
}
