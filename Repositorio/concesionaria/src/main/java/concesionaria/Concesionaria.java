package concesionaria;

import concesionaria.igu.Principal;
import concesionaria.logica.ControladoraLogica;

public class Concesionaria {

    public static void main(String[] args) {
        ControladoraLogica controlL = new ControladoraLogica();
        
        Principal pantallaPrincipal = new Principal();
        pantallaPrincipal.setLocationRelativeTo(null);
        pantallaPrincipal.setVisible(true);
    }
}
