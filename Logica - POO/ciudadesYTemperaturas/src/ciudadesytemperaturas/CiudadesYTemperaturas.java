package ciudadesytemperaturas;

import java.util.Scanner;

public class CiudadesYTemperaturas {

    public static void main(String[] args) {
        String[] nombres = new String[5];
        Double[] tempMin = new Double[5];
        Double[] tempMax = new Double[5];
        
        cargarVectores(nombres, tempMin, tempMax);
        temperaturasMinYMax(nombres, tempMin, tempMax);
    }
    
    public static void cargarVectores(String[]nombres, Double[]tempMin, Double[]tempMax) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        
        System.out.println("Se pedirán datos de las temperaturas que tuvieron 5 ciudades la semana pasada\n");
        
        for (int i = 0; i < 5; i++) {
            System.out.println("ciudad N°" + (i+1));
            System.out.print("Ingrese el nombre: ");
            nombres[i] = leer.next();
            System.out.print("Ingrese la temperatura mínima alcanzada (en Celsius): ");
            tempMin[i] = leer.nextDouble();
            System.out.print("Ingrese la temperatura máxima alcanzada (en Celsius): ");
            tempMax[i] = leer.nextDouble();
            System.out.println("");
        }
    }
    
    public static void temperaturasMinYMax(String[]nombres, Double[]tempMin, Double[]tempMax) {
        Double min = 0.0;
        int auxMin = 0;
        Double max = 0.0;
        int auxMax = 0;
        
        for (int i = 0; i < 5; i++) {
            if(i == 0) {
                min = tempMin[i];
                max = tempMax[i];
            } else {
                if (min > tempMin[i]) {
                    min = tempMin[i];
                    auxMin = i;
                }
                
                if (max < tempMax[i]) {
                    max = tempMax[i];
                    auxMax = i;
                }
            }
        }
        
        System.out.println("Temperatura mínima: " + tempMin[auxMin] + "°C - " + nombres[auxMin]);
        System.out.println("Temperatura máxima: " + tempMax[auxMax] + "°C - " + nombres[auxMax]);
    }
}
