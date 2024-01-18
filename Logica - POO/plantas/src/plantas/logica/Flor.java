package plantas.logica;

public class Flor extends Planta{
    private String colorPetalos;
    private Double promedioPetalos;
    private String colorPistilo;
    private String variedadFlor;
    private String estacionFlorece;

    public Flor() {
    }

    public Flor(String colorPetalos, Double promedioPetalos, String colorPistilo, String variedadFlor, String estacionFlorece, String nombre, int altoTallo, Boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.colorPetalos = colorPetalos;
        this.promedioPetalos = promedioPetalos;
        this.colorPistilo = colorPistilo;
        this.variedadFlor = variedadFlor;
        this.estacionFlorece = estacionFlorece;
    }

    public String getColorPetalos() {
        return colorPetalos;
    }

    public void setColorPetalos(String colorPetalos) {
        this.colorPetalos = colorPetalos;
    }

    public Double getPromedioPetalos() {
        return promedioPetalos;
    }

    public void setPromedioPetalos(Double promedioPetalos) {
        this.promedioPetalos = promedioPetalos;
    }

    public String getColorPistilo() {
        return colorPistilo;
    }

    public void setColorPistilo(String colorPistilo) {
        this.colorPistilo = colorPistilo;
    }

    public String getVariedadFlor() {
        return variedadFlor;
    }

    public void setVariedadFlor(String variedadFlor) {
        this.variedadFlor = variedadFlor;
    }

    public String getEstacionFlorece() {
        return estacionFlorece;
    }

    public void setEstacionFlorece(String estacionFlorece) {
        this.estacionFlorece = estacionFlorece;
    }

    @Override
    public String toString() {
        return super.toString() + "\nFlor:\n colorPetalos = " + colorPetalos + "\n promedioPetalos = " + promedioPetalos + "\n colorPistilo = " + colorPistilo + "\n variedadFlor = " + variedadFlor + "\n estacionFlorece = " + estacionFlorece;
    }

    @Override
    public void decirQueSoy() {
        System.out.println("Hola! Soy una flor");
    }
    
    
}
