package cargavectornumtres;

import java.util.Scanner;

public class CargaVectorNumTres {

    public static void main(String[] args) {
        int[] vector = cargarVector();
        mostrarCantidadNums(vector);
        
    }
    
    public static int[] cargarVector() {
        Scanner leer = new Scanner(System.in);
        int[] vector = new int[15];
        
        System.out.println("Se pedirá que ingrese 15 números enteros");
        
        for (int i = 0; i < vector.length; i++) {
            System.out.println("posición " + i);
            vector[i] = leer.nextInt();
        }
        
        return vector;
    }
    
    public static void mostrarCantidadNums(int[] vector) {
        int contador = 0;
        
        for(int elemento : vector) {
            if (elemento == 3) {
                contador++;
            }
        }
        
        System.out.println("El número 3 apareció " + contador + " veces en el vector");
    }

}
