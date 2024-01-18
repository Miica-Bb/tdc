package logica;

public class Pikachu extends Pokemon implements IElectrico{

    public Pikachu() {
    }
       
    @Override
    protected void atacarPlacaje() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  placaje");
    }

    @Override
    protected void atacarArañazo() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  arañazo");
    }

    @Override
    protected void atacarMordisco() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  mordisco");
    }

    @Override
    public void atacarImpactrueno() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  impactrueno");
    }

    @Override
    public void atacarPunioTrueno() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  puño trueno");
    }

    @Override
    public void atacarRayo() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  rayo");
    }

    @Override
    public void atacarRayoCarga() {
        System.out.println("Soy  Pikachu  y  estoy  atacando  con  rayo de carga");
    }
    
}
