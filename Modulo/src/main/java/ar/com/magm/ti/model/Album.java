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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
public class Album implements Serializable {

    private static final long serialVersionUID = -3235990393994226233L;

    @Id
    @GeneratedValue
    private int idAlbum;

    private String nombre;
    private int año;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "album")
    private List<Cancion> canciones;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idArtista")
    private Artista artista;

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Album() {
        super();
    }

    @Override
    public int hashCode() {
        return getIdAlbum();
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int id) {
        this.idAlbum = id;
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
        return getIdAlbum() == p.getIdAlbum();
    }

    @Override
    public String toString() {
        return String.format("Album: nombre=%s, año=%s", getNombre(), getAño());
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setListaCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }
}
