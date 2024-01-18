package com.example.estaturas.controller;

import com.example.estaturas.model.Jugador;
import com.example.estaturas.service.IJugadorService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JugadorController {
    
    @Autowired
    IJugadorService jugServ; 
    
    @PostMapping("/jugadores/promedioAltura")
    public String promediarAlturas(@RequestBody List<Jugador> listaJugadores) {
        List<Jugador> jugadores = new ArrayList<>();
        jugadores = listaJugadores;
        
        double promedioAlturas = jugServ.promediarAlturas(jugadores);
        
        return "EL promedio de las alturas de los jugadores ingresados es de: " + promedioAlturas;
    }
}
