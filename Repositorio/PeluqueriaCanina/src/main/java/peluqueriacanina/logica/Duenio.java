package peluqueriacanina.logica;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Duenio implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int id_duenio;
    private String nombre_duenio;
    private String celular;
    private String direccion;

    public Duenio() {
    }

    public Duenio(int id_duenio, String nombre_duenio, String celular, String direccion) {
        this.id_duenio = id_duenio;
        this.nombre_duenio = nombre_duenio;
        this.celular = celular;
        this.direccion = direccion;
    }

    public int getId_duenio() {
        return id_duenio;
    }

    public void setId_duenio(int id_duenio) {
        this.id_duenio = id_duenio;
    }

    public String getNombre_duenio() {
        return nombre_duenio;
    }

    public void setNombre_duenio(String nombre_duenio) {
        this.nombre_duenio = nombre_duenio;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Duenio{" + "id_duenio=" + id_duenio + ", nombre_duenio=" + nombre_duenio + ", celular=" + celular + ", direccion=" + direccion + '}';
    }    
}
