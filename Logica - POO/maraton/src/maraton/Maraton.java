package maraton;

import java.util.Scanner;

public class Maraton {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String nombre, dni;
        int edad;
        
        System.out.println("Este programa registra usuarios para la maratón");
        System.out.println("Se pedirá que ingrese nombre, dni y edad del participante");
        System.out.println("Para finalizar los ingresos, escribir '0' para el dni y 'salir' para el nombre\n");
        
        do {
            System.out.print("Nombre del participante: ");
            nombre = leer.next();
            System.out.print("dni del participante: ");
            dni = leer.next();
            
            if (!dni.equals("0") || !nombre.equalsIgnoreCase("fin")) {
                System.out.print("Edad del participante: ");
                edad = leer.nextInt();
                
                if (edad >= 6 && edad <= 10) {
                    System.out.println("Participante inscripto en categoría 'Menores A'\n");
                } else if (edad >= 11 && edad <= 17) {
                    System.out.println("Participante inscripto en categoría 'Menores B'\n");
                } else if (edad >= 18 && edad <= 30) {
                    System.out.println("Participante inscripto en categoría 'Juveniles'\n");
                } else if (edad >= 31 && edad <= 50) {
                    System.out.println("Participante inscripto en categoría 'Adultos'\n");
                } else if (edad > 50) {
                    System.out.println("Participante inscripto en categoría 'Adultos mayores'\n");
                } else {
                    System.out.println("La edad del participante no es suficiente para participar\n");
                }
            }
            
        } while (!dni.equals("0") || !nombre.equalsIgnoreCase("fin"));
    }

}
