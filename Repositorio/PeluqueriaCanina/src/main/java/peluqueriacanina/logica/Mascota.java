package peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Mascota implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int num_cliente;
    private String nombre_perro;
    private String raza;
    private String color;
    private String esAlergico;
    private String atencion_especial;
    private String observaciones;
    @OneToOne
    private Duenio duenio;

    public Mascota() {
    }

    public Mascota(int num_cliente, String nombre_perro, String raza, String color, String esAlergico, String atencion_especial, String observaciones, Duenio duenio) {
        this.num_cliente = num_cliente;
        this.nombre_perro = nombre_perro;
        this.raza = raza;
        this.color = color;
        this.esAlergico = esAlergico;
        this.atencion_especial = atencion_especial;
        this.observaciones = observaciones;
        this.duenio = duenio;
    }   

    public Duenio getDuenio() {
        return duenio;
    }

    public void setDuenio(Duenio duenio) {
        this.duenio = duenio;
    }

    public int getNum_cliente() {
        return num_cliente;
    }

    public void setNum_cliente(int num_cliente) {
        this.num_cliente = num_cliente;
    }

    public String getNombre_perro() {
        return nombre_perro;
    }

    public void setNombre_perro(String nombre_perro) {
        this.nombre_perro = nombre_perro;
    }

    public String getEsAlergico() {
        return esAlergico;
    }

    public void setEsAlergico(String esAlergico) {
        this.esAlergico = esAlergico;
    }

    public String getAtencion_especial() {
        return atencion_especial;
    }

    public void setAtencion_especial(String atencion_especial) {
        this.atencion_especial = atencion_especial;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    @Override
    public String toString() {
        return "Mascota{" + "num_cliente=" + num_cliente + ", nombre_perro=" + nombre_perro + ", raza=" + raza + ", color=" + color + ", esAlergico=" + esAlergico + ", atencion_especial=" + atencion_especial + ", observaciones=" + observaciones + ", duenio=" + duenio + '}';
    }
}
