package com.mycompany.login;

import com.mycompany.login.igu.PantallaAcceso;
import com.mycompany.login.logica.ControladoraLogica;

public class Login {

    public static void main(String[] args) {
        ControladoraLogica controlL = new ControladoraLogica();
        
        PantallaAcceso pAcceso = new PantallaAcceso();
        pAcceso.setLocationRelativeTo(null);
        pAcceso.setVisible(true);
    }
}
