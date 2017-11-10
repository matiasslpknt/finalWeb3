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
@Table(name = "artista")
public class Artista implements Serializable {

    private static final long serialVersionUID = -3235990393994226233L;

    @Id
    @GeneratedValue
    private int id;
    private String nombre;
    private String genero;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idArtista")
    private List<Concierto> conciertos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idArtista")
    private List<Album> albums;

    public void setId(int id) {
        this.id = id;
    }

    public Artista() {
        super();
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @Override
    public boolean equals(Object obj) {
        Artista p = (Artista) obj;
        return getId() == p.getId();
    }

    public List<Concierto> getConciertos() {
        return conciertos;
    }

    public void setConciertos(List<Concierto> conciertos) {
        this.conciertos = conciertos;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }

    @Override
    public String toString() {
        return String.format("Artista: Artista=%s, genero=%s", getNombre(), getGenero());
    }
}
