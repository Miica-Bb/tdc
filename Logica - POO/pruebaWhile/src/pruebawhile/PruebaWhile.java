package pruebawhile;

import java.util.Scanner;

public class PruebaWhile {

    public static void main(String[] args) {
        int limite = pedirLimite();
        recorrerBucle(limite);
    }
    
    public static int pedirLimite() {
        Scanner leer = new Scanner(System.in);
        int limite;
        
        System.out.println("Ingrese el límite que tendrá el bucle (num entero)");
        limite = leer.nextInt();
        
        return limite;
    }
    
    public static void recorrerBucle(int limite) {
        int contador = 1;
        
        while(contador <= limite) {
            System.out.println("Voy por la vuelta " + contador);
            contador++;
        }
    }

}
