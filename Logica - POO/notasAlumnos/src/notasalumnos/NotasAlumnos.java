package notasalumnos;

import java.util.Scanner;

public class NotasAlumnos {

    public static void main(String[] args) {
//        String[] nombres = cargarNombres();
//        double[][] notas = cargarNotas(nombres);

        String[] nombres = new String[4];
        double[][] notas = new double[4][4];
        cargarArreglos(notas, nombres);
        notas = calcularPromedio(notas);
        mostrarNotas(notas, nombres);
    }
    
    /*
    public static String[] cargarNombres() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String[] nombres = new String[4];
        
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el nombre del " + (i + 1) + "° alumno: ");
            nombres[i] = leer.next();
        }
        System.out.println("");
        
        return nombres;
    }
    
    public static double[][] cargarNotas(String[] nombres) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        double[][] notas = new double[4][4];
        
        System.out.println("A continuación, se pedirá que ingrese las tres notas correspondientes a cada alumno:");
        for (int f = 0; f < 4; f++) {
            System.out.println("Alumno " + nombres[f]);
            for (int c = 0; c < 3; c++) {
                System.out.print((c + 1) + "° nota: ");
                notas[f][c] = leer.nextDouble();                
            }
            System.out.println("");
        }
        
        return notas;
    }
    */
    
    public static void cargarArreglos(double[][] notas, String[] nombres) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        for (int f = 0; f < 4; f++) {
            System.out.println((f + 1) + "° alumno: ");
            System.out.print("nombre: ");
            nombres[f] = leer.next();

            for (int c = 0; c < 3; c++) {
                System.out.print((c + 1) + "° nota: ");
                notas[f][c] = leer.nextDouble();                
            }
            System.out.println("");
        }
    }
    
    public static double[][] calcularPromedio(double[][] notas) {
        double promedio = 0.0;
        
        for (int f = 0; f < notas.length; f++) {
            for (int c = 0; c < notas.length; c++) {
                promedio += notas[f][c];
                
                if (c == (notas.length - 1)) {
                    promedio = promedio / 3;
                    notas[f][c] = promedio;
                }
            }
            promedio = 0;
        }
        
        return notas;
    }
    
    public static void mostrarNotas(double[][] notas, String[] nombres) {
        for (int f = 0; f < nombres.length; f++) {
            System.out.println("Notas de " + nombres[f]);
            
            for (int c = 0; c < nombres.length; c++) {
                if (c < (nombres.length - 1)) {
                    System.out.println((c + 1) + "° nota: " + notas[f][c]);
                } else {
                    System.out.println("promedio: " + notas[f][3]);
                }
            }
            System.out.println("");
        }
    }
}
