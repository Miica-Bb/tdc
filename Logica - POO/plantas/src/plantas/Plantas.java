package plantas;

import plantas.logica.Arbol;
import plantas.logica.Arbusto;
import plantas.logica.Flor;

public class Plantas {

    public static void main(String[] args) {
        Arbol a = new Arbol();
        Flor f = new Flor();
        Arbusto b = new Arbusto();
        
        a.decirQueSoy();
        System.out.println(a.toString());
        f.decirQueSoy();
        System.out.println(f.toString());
        b.decirQueSoy();
        System.out.println(b.toString());
    }

}
