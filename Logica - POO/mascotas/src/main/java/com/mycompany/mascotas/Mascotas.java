package com.mycompany.mascotas;

import com.mycompany.mascotas.logica.ControladoraLogica;
import com.mycompany.mascotas.logica.Perro;
import java.util.ArrayList;
import java.util.Date;

public class Mascotas {

    public static void main(String[] args) {
        ControladoraLogica controlL = new ControladoraLogica();
        
        /*
        Perro uno = new Perro(1, "Sofi", "Mestiza", new Date(2005, 03, 12));
        controlL.crearPerro(uno);
        Perro dos = new Perro(2, "Loly", "Caniche", new Date());
        controlL.crearPerro(dos);
        Perro tres = new Perro(3, "Sultán", "Mestizo", new Date());
        controlL.crearPerro(tres);
        
        
        controlL.eliminarPerro(4);
        controlL.eliminarPerro(5);
        controlL.eliminarPerro(6);
        
        
        Perro edit = controlL.buscarPerro(1);
        edit.setFechaNac(new Date(2005-1900, 03, 13));
        controlL.editarPerro(edit);
        */
        Perro segundo = controlL.buscarPerro(2);
        System.out.println("Datos del segundo perro: " + segundo.toString());
        System.out.println("_________________________________________");
        ArrayList<Perro> lista = controlL.buscarTotalPerros();
        for(Perro elemento : lista) {
            System.out.println("Datos del perro: " + elemento.toString());
        }
        
    }
}
