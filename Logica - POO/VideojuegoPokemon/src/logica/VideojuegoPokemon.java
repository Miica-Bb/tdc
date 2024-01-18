package logica;

public class VideojuegoPokemon {

    public static void main(String[] args) {
        
        Pikachu pika = new Pikachu();
        Charmander charmander = new Charmander();
        Bulbasaur bul = new Bulbasaur();
        Squirtle sqr = new Squirtle();
        
        System.out.println("____________________");
        pika.atacarArañazo();
        pika.atacarMordisco();
        pika.atacarPlacaje();
        pika.atacarImpactrueno();
        pika.atacarPunioTrueno();
        pika.atacarRayo();
        pika.atacarRayoCarga();
        System.out.println("____________________");
        charmander.atacarArañazo();
        charmander.atacarAscuas();
        charmander.atacarLanzallamas();
        charmander.atacarMordisco();
        charmander.atacarPlacaje();
        charmander.atacarPunioFuego();
        System.out.println("____________________");
        bul.atacarArañazo();
        bul.atacarDrenaje();
        bul.atacarHojaAfilada();
        bul.atacarLatigoCepa();
        bul.atacarMordisco();
        bul.atacarParalizar();
        bul.atacarPlacaje();
        System.out.println("____________________");
        sqr.atacarArañazo();
        sqr.atacarBurbuja();
        sqr.atacarHidrobomba();
        sqr.atacarHidropulso();
        sqr.atacarMordisco();
        sqr.atacarPistolaAgua();
        sqr.atacarPlacaje();
    }

}
