package com.example.ejPracticoDentista.Controller;

import com.example.ejPracticoDentista.Paciente;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DentistaController {
    
    public List<Paciente> buscarPacientes() {
        List<Paciente> listaPacientes = new ArrayList<>();
        listaPacientes.add(new Paciente(1, "1122333", "Mica", "Br", LocalDate.of(1997, 1, 13)));
        listaPacientes.add(new Paciente(2, "22333444", "Gretchen", "Ga", LocalDate.of(2014, 11, 14)));
        listaPacientes.add(new Paciente(3, "44555666", "Lucho", "Ga", LocalDate.of(2014, 11, 14)));
        listaPacientes.add(new Paciente(4, "55666777", "Vicky", "Br", LocalDate.of(1991, 10, 17)));
        listaPacientes.add(new Paciente(5, "66777888", "Nico", "Br", LocalDate.of(1995, 7, 31)));
        listaPacientes.add(new Paciente(6, "77888999", "Gaby", "Pa", LocalDate.of(1969, 7, 24)));
        listaPacientes.add(new Paciente(7, "88999101", "Loly", "Br", LocalDate.of(2012, 9, 25)));
        listaPacientes.add(new Paciente(8, "99101111", "Sultán", "Br", LocalDate.of(2017, 5, 27)));
        listaPacientes.add(new Paciente(9, "10111121", "Sofi", "Br", LocalDate.of(2012, 3, 13)));
        listaPacientes.add(new Paciente(10, "11121131", "Lola", "Pa", LocalDate.of(2000, 1, 1)));
        
        return listaPacientes;
    }
    
    @GetMapping("/paciente/listaCompleta")
    @ResponseBody
    public List<Paciente> mostrarPacientes() {
        List<Paciente> listaCompletaPacientes = buscarPacientes();
        return listaCompletaPacientes;
    }
    
    @GetMapping("/paciente/listaMenores")
    @ResponseBody
    public List<Paciente> mostrarPacientesMenores() {
        List<Paciente> listaPacientes = buscarPacientes();
        List<Paciente> listaPacientesMenores = new ArrayList<>();
        
        for(Paciente pac : listaPacientes) {
            if (Period.between(pac.getFechaNacimiento(), LocalDate.now()).getYears() < 18) {
                listaPacientesMenores.add(pac);
            }
        }
        
        return listaPacientesMenores;
    }
}
