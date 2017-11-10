package ar.com.magm.ti.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "album")
public class Album implements Serializable {

    private static final long serialVersionUID = -3235990393994226233L;

    @Id
    @GeneratedValue
    private int id;

    private String nombre;
    private int año;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAlbum")
    private List<Cancion> listaCanciones;

    public Album() {
        super();
    }

    @Override
    public int hashCode() {
        return getId();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    @Override
    public boolean equals(Object obj) {
        Album p = (Album) obj;
        return getId() == p.getId();
    }

    @Override
    public String toString() {
        return String.format("Album: nombre=%s, año=%s", getNombre(), getAño());
    }

    public List<Cancion> getListaCanciones() {
        return listaCanciones;
    }

    public void setListaCanciones(List<Cancion> listaCanciones) {
        this.listaCanciones = listaCanciones;
    }
}
