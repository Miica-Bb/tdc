package intercambiovariables;

import java.util.Scanner;

public class IntercambioVariables {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        
        int num1, num2, aux;
        
        System.out.println("Ingrese el primer número");
        num1 = leer.nextInt();
        System.out.println("Ingrese el segundo número");
        num2 = leer.nextInt();
        
        System.out.println("\nVariables antes del intercambio:");
        System.out.println("Primer número: " + num1);
        System.out.println("Segundo número: " + num2);
        
        aux = num1;
        num1 = num2;
        num2 = aux;
        
        System.out.println("\nVariables luego del intercambio:");
        System.out.println("Primer número: " + num1);
        System.out.println("Segundo número: " + num2);
    }

}
