package salarioempleadosdespensa;

import java.util.Scanner;

public class SalarioEmpleadosDespensa {

    public static void main(String[] args) {
        String puestoEmpleado = puestoEmpleado();
        salarioEmpleado(puestoEmpleado);
    }
    
    public static String puestoEmpleado() {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        String puesto;
        
        do {
            System.out.println("Ingrese el puesto de trabajo del empleado, siendo:");
            System.out.println("1. Repositor");
            System.out.println("2. Cajero");
            System.out.println("3. Supervisor");
            puesto = leer.next();
            
            if (!"1".equals(puesto) && !"2".equals(puesto) && !"3".equals(puesto)) {
                System.out.println("Valor ingresado incorrecto. Ingrese 1, 2 o 3 según corresponda");
            }
        } while (!"1".equals(puesto) && !"2".equals(puesto) && !"3".equals(puesto));
        
        return puesto;
    }
    
    public static void salarioEmpleado(String puestoEmpleado) {
        double salario = 0;
        
        switch(puestoEmpleado) {
            case "1":
                salario = 15890 + 15890 * 0.1;
                break;
            case "2":
                salario = 25630.89;
                break;
            case "3":
                salario = 35560.20 - 35560.20 * 0.11;
                break;
        }
        
        System.out.println("El salario es de $" + salario);
    }
}
