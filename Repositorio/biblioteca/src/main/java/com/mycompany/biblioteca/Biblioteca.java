package com.mycompany.biblioteca;

import com.mycompany.biblioteca.igu.pantallaCarga;
import com.mycompany.biblioteca.logica.ControladoraLogica;

public class Biblioteca {

    public static void main(String[] args) {
        ControladoraLogica controlL = new ControladoraLogica();
        pantallaCarga pCarga = new pantallaCarga(controlL);
        pCarga.setLocationRelativeTo(null);
        pCarga.setVisible(true);
    }
}
