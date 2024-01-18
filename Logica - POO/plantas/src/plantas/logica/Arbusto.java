package plantas.logica;

public class Arbusto extends Planta{
    private Double anchoArbusto;
    private Boolean esDomestico;
    private String variedadArbusto;
    private String colorHojas;
    private Boolean sePoda;

    public Arbusto() {
    }

    public Arbusto(Double anchoArbusto, Boolean esDomestico, String variedadArbusto, String colorHojas, Boolean sePoda, String nombre, int altoTallo, Boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.anchoArbusto = anchoArbusto;
        this.esDomestico = esDomestico;
        this.variedadArbusto = variedadArbusto;
        this.colorHojas = colorHojas;
        this.sePoda = sePoda;
    }

    public Double getAnchoArbusto() {
        return anchoArbusto;
    }

    public void setAnchoArbusto(Double anchoArbusto) {
        this.anchoArbusto = anchoArbusto;
    }

    public Boolean getEsDomestico() {
        return esDomestico;
    }

    public void setEsDomestico(Boolean esDomestico) {
        this.esDomestico = esDomestico;
    }

    public String getVariedadArbusto() {
        return variedadArbusto;
    }

    public void setVariedadArbusto(String variedadArbusto) {
        this.variedadArbusto = variedadArbusto;
    }

    public String getColorHojas() {
        return colorHojas;
    }

    public void setColorHojas(String colorHojas) {
        this.colorHojas = colorHojas;
    }

    public Boolean getSePoda() {
        return sePoda;
    }

    public void setSePoda(Boolean sePoda) {
        this.sePoda = sePoda;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArbusto:\n anchoArbusto = " + anchoArbusto + "\n esDomestico = " + esDomestico + "\n variedadArbusto = " + variedadArbusto + "\n colorHojas = " + colorHojas + "\n sePod a= " + sePoda;
    }

    @Override
    public void decirQueSoy() {
        System.out.println("Hola! Soy un arbusto");
    }
    
    
}
