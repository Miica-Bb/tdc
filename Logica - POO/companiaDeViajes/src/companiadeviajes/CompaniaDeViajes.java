package companiadeviajes;

import java.util.Scanner;

public class CompaniaDeViajes {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String[] destinos = new String[6];
        String[] vuelos = new String[3];
        int[][] asientos = new int[6][3];
        String venta;
        
        cargarArreglos(destinos, vuelos, asientos);
        
        System.out.println("Desea realizar una compra? (escribir 'finish' en caso de no querer hacerlo)");
        venta = leer.next().toLowerCase();
        
        while(!venta.equals("finish")) {
            comprarPasajes(asientos);
            mostrarMatriz(destinos, vuelos, asientos);
            
            System.out.println("Desea realizar otra compra? (escribir 'finish' en caso de no querer hacerlo)");
            venta = leer.next().toLowerCase();
        }
    }
    
    public static void cargarArreglos(String[] destinos, String[] vuelos, int[][] asientos) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        vuelos[0] = "Manana";
        vuelos[1] = "Tarde";
        vuelos[2] = "Noche";
        
        destinos[0] = "R.Janeiro";
        destinos[1] = "Cancun";
        destinos[2] = "Madrid";
        destinos[3] = "Roma";
        destinos[4] = "Milan";
        destinos[5] = "Iguazu";
        
        for (int i = 0; i < destinos.length; i++) {               //i recorre los destinos
            System.out.println("Destino a " + destinos[i]);
            
            for (int j = 0; j < vuelos.length; j++) {             //j recorre los vuelos
                System.out.print("Ingrese los asientos disponibles para el vuelo de la " + vuelos[j] + ": ");
                asientos[i][j] = leer.nextInt();                
            }
            
            System.out.println("");
        }
    }
    
    public static void comprarPasajes(int[][] asientos) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        int destino, vuelo, pasajes;
        
        do {
            System.out.println("Ingrese el número del destino al que desea viajar: ");
            System.out.println("0. Río de Janeiro");
            System.out.println("1. Cancún");
            System.out.println("2. Madrid");
            System.out.println("3. Roma");
            System.out.println("4. Milán");
            System.out.println("5. Iguazú");
            destino = leer.nextInt();
            
            if (destino < 0 || destino > 5) {
                System.out.println("Ingreso incorrecto, intente nuevamente");
            }
        } while(destino < 0 || destino > 5);
        
        System.out.println("");
        
        do {
            System.out.println("Ingrese el número del vuelo al que desea anotarse: ");
            System.out.println("0. Mañana");
            System.out.println("1. Tarde");
            System.out.println("2. Noche");
            vuelo = leer.nextInt();
            
            if (vuelo < 0 || vuelo > 2) {
                System.out.println("Ingreso incorrecto, intente nuevamente");
            }
        } while (vuelo < 0 || vuelo > 2);
        
        System.out.println("");
        System.out.println("------------------------");
        System.out.println("¿Cuántos pasajes desea comprar?");
        pasajes = leer.nextInt();
        
        if (asientos[destino][vuelo] >= pasajes) {
            System.out.println("Su reserva fue realizada con éxito");
            asientos[destino][vuelo] = asientos[destino][vuelo] - pasajes;
        } else {
            System.out.println("Disculpe, no se pudo completar su operación dado que no hay asientos disponibles");
        }
    }
    
    public static void mostrarMatriz(String[] destinos, String[] vuelos, int[][] asientos) {
        for (int i = 0; i < destinos.length; i++) {
            System.out.print(destinos[i] + "     ");
            
            for (int j = 0; j < vuelos.length; j++) {
                System.out.print(asientos[i][j] + "    ");
            }
            
            System.out.println("");
        }
    }

}
