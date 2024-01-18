package logica;

public abstract class Pokemon {
    protected int numPokedex;
    protected String nombre;
    protected double peso;
    protected String temporadaQueAparece;
    protected String sexo;

    public Pokemon() {
    }

    public Pokemon(int numPokedex, String nombre, double peso, String temporadaQueAparece, String sexo) {
        this.numPokedex = numPokedex;
        this.nombre = nombre;
        this.peso = peso;
        this.temporadaQueAparece = temporadaQueAparece;
        this.sexo = sexo;
    }

    public int getNumPokedex() {
        return numPokedex;
    }

    public void setNumPokedex(int numPokedex) {
        this.numPokedex = numPokedex;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getTemporadaQueAparece() {
        return temporadaQueAparece;
    }

    public void setTemporadaQueAparece(String temporadaQueAparece) {
        this.temporadaQueAparece = temporadaQueAparece;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
      
    protected abstract void atacarPlacaje();
    
    protected abstract void atacarArañazo();
    
    protected abstract void atacarMordisco();
}
