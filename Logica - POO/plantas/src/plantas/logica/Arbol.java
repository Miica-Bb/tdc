package plantas.logica;

public class Arbol extends Planta{
    private String variedad;
    private String tipoTronco;
    private Double radioTronco;
    private String color;
    private String tipoHojas;

    public Arbol() {
    }

    public Arbol(String variedad, String tipoTronco, Double radioTronco, String color, String tipoHojas, String nombre, int altoTallo, Boolean tieneHojas, String climaIdeal) {
        super(nombre, altoTallo, tieneHojas, climaIdeal);
        this.variedad = variedad;
        this.tipoTronco = tipoTronco;
        this.radioTronco = radioTronco;
        this.color = color;
        this.tipoHojas = tipoHojas;
    }

    public String getVariedad() {
        return variedad;
    }

    public void setVariedad(String variedad) {
        this.variedad = variedad;
    }

    public String getTipoTronco() {
        return tipoTronco;
    }

    public void setTipoTronco(String tipoTronco) {
        this.tipoTronco = tipoTronco;
    }

    public Double getRadioTronco() {
        return radioTronco;
    }

    public void setRadioTronco(Double radioTronco) {
        this.radioTronco = radioTronco;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipoHojas() {
        return tipoHojas;
    }

    public void setTipoHojas(String tipoHojas) {
        this.tipoHojas = tipoHojas;
    }

    @Override
    public String toString() {
        return super.toString() + "\nArbol:\n variedad = " + variedad + "\n tipoTronco = " + tipoTronco + "\n radioTronco = " + radioTronco + "\n color = " + color + "\n tipoHojas = " + tipoHojas;
    }

    @Override
    public void decirQueSoy() {
        System.out.println("Hola! Soy un árbol");
    }
    
    
}
