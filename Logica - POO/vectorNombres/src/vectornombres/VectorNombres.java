package vectornombres;

import java.util.Scanner;

public class VectorNombres {

    public static void main(String[] args) {
        String[] nombres = cargarVector();
        recorrerVector(nombres);
    }
    
    public static String[] cargarVector() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String[] nombres;
        
        System.out.println("¿Cuántos nombres desea ingresar?");
        int longitud = leer.nextInt();
        
        nombres = new String[longitud];
        
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Ingrese el " + (i + 1) + "° nombre: ");
            nombres[i] = leer.next();
        }
        System.out.println("");
        
        return nombres;
    }
    
    public static void recorrerVector(String[] nombres) {
        System.out.println("Vector de nombres: ");
        for(String elemento : nombres) {
            System.out.print(elemento + " ");
        }
        System.out.println("");
    }

}
