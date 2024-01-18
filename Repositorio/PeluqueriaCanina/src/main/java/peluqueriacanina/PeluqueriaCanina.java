package peluqueriacanina;

import peluqueriacanina.igu.Principal;
import peluqueriacanina.logica.ControladoraLogica;

public class PeluqueriaCanina {

    public static void main(String[] args) {
        ControladoraLogica controlL = new ControladoraLogica();
        
        Principal menu = new Principal();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
        
        
    }
}
