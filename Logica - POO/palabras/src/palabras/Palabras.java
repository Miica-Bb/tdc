package palabras;

import java.util.Scanner;

public class Palabras {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        String palabra;
        
        System.out.println("Ingrese palabras (ingrese salir para terminar): ");
        
        do {
            palabra = leer.next();
            if (palabra.equalsIgnoreCase("salir")) {
                System.out.println("Programa finalizado");
            } else {
                System.out.println("Palabra ingresada: " + palabra);
            }
        } while (!"salir".equalsIgnoreCase(palabra));
    }

}
