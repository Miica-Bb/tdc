package Logica;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class EjVideojuegos {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        List<Videojuego> juegos = new ArrayList<>();
        String respuesta;
        Boolean condicion = false;

        System.out.println("Desea agregar un nuevo Videojuego a la lista? S para si, otro caracter para no");
        respuesta = leer.next().toUpperCase();

        if (respuesta.equals("S")) {
            condicion = true;
        }

        while (condicion == true) {
            agregarVideojuego(juegos);
            System.out.println("Desea agregar otro videojuego? S para si, otro caracter para no");
            respuesta = leer.next().toUpperCase();

            if (respuesta.equals("S")) {
                condicion = true;
            } else {
                condicion = false;
            }
        }
        System.out.println("***************************");
        
        recorrerListaVideojuegos(juegos);
        juegos.get(0).setTitulo("Mario Bros");
        juegos.get(0).setCantJugadores(2);
        juegos.get(3).setTitulo("Hollow Knight");
        juegos.get(3).setCantJugadores(1);
        recorrerListaVideojuegos(juegos);
        buscarEnLista(juegos);
    }

    public static void agregarVideojuego(List<Videojuego> juegos) {
        Scanner leer = new Scanner(System.in).useDelimiter("\n");
        Videojuego juego = new Videojuego();
        String aux;

        System.out.print("Ingrese el código del juego: ");
        juego.setCodigo(leer.next());
        System.out.print("Ingrese el título del juego: ");
        juego.setTitulo(leer.next());
        System.out.print("Ingrese la consola que soporta el juego: ");
        juego.setConsola(leer.next());
        System.out.print("Ingrese el género del juego: ");
        juego.setCategoria(leer.next());
        try {
            System.out.print("Ingrese la cantidad de jugadores del juego: ");
            juego.setCantJugadores(leer.nextInt());
        } catch(InputMismatchException e) {
            aux = leer.next();
            System.out.print("Ingrese un valor numérico para la cantidad de jugadores: ");
            juego.setCantJugadores(leer.nextInt());
        } finally {
            System.out.println("_______________________________");

            juegos.add(juego);
        }
    }
    
    public static void recorrerListaVideojuegos(List<Videojuego> juegos) {
        for(Videojuego juego : juegos) {
            System.out.println("Título: " + juego.getTitulo() + ", consola: " + juego.getConsola() + ", cantidad de jugadores: " + juego.getCantJugadores());
        }
        System.out.println("");
    }
    
    public static void buscarEnLista(List<Videojuego> juegos) {
        for (int i = 0; i < juegos.size(); i++) {
            if(juegos.get(i).getConsola().equalsIgnoreCase("nintendo 64")) {
                System.out.println(juegos.get(i).toString());
            }
        }
    }
}
