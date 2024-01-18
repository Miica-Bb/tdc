package pruebatecnicatrainee;

import java.util.Scanner;

public class PruebaTecnicaTrainee {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String centinela, ver;
        int reservaFila, reservaAsiento;
        String asientos[][] = new String[10][10];
        
        
        //carga del mapa de filas y asientos
        for (int fila = 0; fila < 10; fila++) {
            for (int asiento = 0; asiento < 10; asiento++) {
                asientos[fila][asiento] = "L";
            }
        }
        
        //reserva de asientos
        System.out.println("Desea reservar una entrada? (ingrese 's' en caso de desearlo o cualquier caracter para cerrar el programa)");
        centinela = leer.next();
        
        while (centinela.equalsIgnoreCase("s")) {
            System.out.println("\nDesea ver los asientos disponilbes? ('s' para si, cualquier caracter para no)");
            ver = leer.next();
            
            if (ver.equalsIgnoreCase("s")) {
                mostrarAsientos(asientos);
                System.out.println("");
            }
            
            do {
                System.out.print("Ingrese el número de la fila deseada (de 0 a 9): ");
                reservaFila = leer.nextInt();
                
                if (reservaFila < 0 || reservaFila > 9) {
                    System.out.println("Ingreso incorrecto. Las filas van del 0 al 9");
                }
            } while (reservaFila < 0 || reservaFila > 9);
            
            do {
                System.out.print("Ingrese el número del asiento deseado (de 0 a 9): ");
                reservaAsiento = leer.nextInt();
                
                if (reservaAsiento < 0 || reservaAsiento > 9) {
                    System.out.println("Ingreso incorrecto. Los asientos van del 0 al 9");
                }
            } while (reservaAsiento < 0 || reservaAsiento > 9);
            
            if(asientos[reservaFila][reservaAsiento].equals("L")) {
                System.out.println("Asiento reservado");
                asientos[reservaFila][reservaAsiento] = "X";
                
            } else {
                System.out.println("El asiento seleccionado no está disponible");
            }
            
            System.out.println("\nDesea reservar otro asiento? ('s' para si, cualquier otro caracter para no)");
            centinela = leer.next();
        }
    }
    
    public static void mostrarAsientos(String[][] asientos) {
        //los vectores filas y lugares es para presentación más amistosa a la vista de los asientos disponibles
        int[] lugares = new int[10];
        
        for (int i = 0; i < 10; i++) {
            lugares[i] = i;
        }
        
        for (int i = 0; i < 10; i++) {
            if(i == 0) {
                System.out.print("    " + lugares[i] + " ");
            } else {
                System.out.print(lugares[i] + " ");
            }
        }
        System.out.println("\n");
        
        //muestro los asientos en si
        for (int i = 0; i < 10; i++) {
            System.out.print(i + "   ");
            
            for (int j = 0; j < 10; j++) {
                System.out.print(asientos[i][j] + " ");
            }
            System.out.println("");
        }
    }

}
