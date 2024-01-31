package practica;

import java.time.LocalDate;
import java.time.Month;

public class Practica {

    public static void main(String[] args) {
        /*
        Double total = 0.0;
        
        System.out.println("valor al inicio: " + total);
        
        for (int i = 0; i < 10; i++) {
            total += i;
            
            System.out.println("valor en bucle: " + total);
        }
        
        System.out.println("valor al final: " + total);
         */

        ////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////
        
        /*
        LocalDate fecha1 = LocalDate.now();
        System.out.println("fecha1: " + fecha1);
        
        LocalDate fecha2 = LocalDate.parse("1997-01-13");
        System.out.println("Fecha2: " + fecha2);
        
        LocalDate fecha3 = LocalDate.of(2005, Month.MARCH, 13);
        System.out.println("fecha3: " + fecha3);
         */
        
        ////////////////////////////////////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////
        
        int num = 25;
        
        for (int i = 0; i < 10; i++) {
            num -= 5;
            

            if(num == 15) {

            } else {
                System.out.println(num);
            }
        }
    }

}
