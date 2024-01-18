package com.example.estaturas.service;

import com.example.estaturas.model.Jugador;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JugadorService implements IJugadorService {

    @Override
    public double promediarAlturas(List<Jugador> listaJugadores) {
        double promedioAltura = 0;
        
        for(Jugador jug : listaJugadores) {
            promedioAltura += jug.getAltura();
        }
        
        promedioAltura /= listaJugadores.size();
        
        return promedioAltura;
    }
    
}
