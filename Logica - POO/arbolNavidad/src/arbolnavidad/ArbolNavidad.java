package arbolnavidad;

import java.util.Scanner;

public class ArbolNavidad {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);                                                    //ejemplo 4 altura 1 de largo
        System.out.println("Ingrese la altura del árbol");                                            //   *
        int altura = leer.nextInt();                                                                    //  ***
        System.out.println("Ingrese el largo del tronco");                                            // *****
        int largoTronco = leer.nextInt();                                                               //*******                 
        System.out.println("\n\n\n\n");                                                               //  |||

        for (int fila = 0; fila < altura; fila++) {
            //espacios
            for (int espacio = 0; espacio < (altura - fila - 1); espacio++) {
                System.out.print(" ");
            }
            //asteriscos
            for (int asterisco = 0; asterisco < (fila * 2 + 1); asterisco++) {
                System.out.print("*");
            }
            System.out.println("");
        }
        
        for (int base = 0; base < largoTronco; base++) {
            //espacios
            for (int espacio = 0; espacio < (altura - 2); espacio++) {
                System.out.print(" ");
            }
            //palitos
            for (int palo = 0; palo < 3; palo++) {
                System.out.print("|");
            }
            System.out.println("");
        }
        
        System.out.println("\n\n");
    }

}
