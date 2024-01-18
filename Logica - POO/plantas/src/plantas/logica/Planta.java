package plantas.logica;

public abstract class Planta {
    protected String nombre;
    protected int altoTallo;
    protected Boolean tieneHojas;
    protected String climaIdeal;

    public Planta() {
    }

    public Planta(String nombre, int altoTallo, Boolean tieneHojas, String climaIdeal) {
        this.nombre = nombre;
        this.altoTallo = altoTallo;
        this.tieneHojas = tieneHojas;
        this.climaIdeal = climaIdeal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAltoTallo() {
        return altoTallo;
    }

    public void setAltoTallo(int altoTallo) {
        this.altoTallo = altoTallo;
    }

    public Boolean getTieneHojas() {
        return tieneHojas;
    }

    public void setTieneHojas(Boolean tieneHojas) {
        this.tieneHojas = tieneHojas;
    }

    public String getClimaIdeal() {
        return climaIdeal;
    }

    public void setClimaIdeal(String climaIdeal) {
        this.climaIdeal = climaIdeal;
    }

    @Override
    public String toString() {
        return "Planta:\n nombre = " + nombre + "\n altoTallo = " + altoTallo + "\n tieneHojas = " + tieneHojas + "\n climaIdeal = " + climaIdeal;
    }
    
    protected abstract void decirQueSoy();
}
