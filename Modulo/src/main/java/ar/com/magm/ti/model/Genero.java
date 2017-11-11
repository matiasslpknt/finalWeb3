package ar.com.magm.ti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "genero")
public class Genero implements Serializable {

    private static final long serialVersionUID = 2464927409480955012L;
    @Id
    @GeneratedValue
    private int idGenero;
    private String nombre;
    
    @OneToMany(mappedBy = "genero")
    private List<Cancion> canciones;

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
    
    public Genero() {
        super();
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return getIdGenero();

    }

    @Override
    public String toString() {
        return String.format("Genero: %s - %s", getIdGenero(), getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        return getIdGenero() == ((Genero) obj).getIdGenero();
    }
}
