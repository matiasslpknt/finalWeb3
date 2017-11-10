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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "playlist")
public class Playlist implements Serializable {

    private static final long serialVersionUID = 2464927409480955012L;
    @Id
    @GeneratedValue
    private int idPlaylist;
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Playlist_Cancion", joinColumns = {
        @JoinColumn(name = "idPlaylist")}, inverseJoinColumns = {
        @JoinColumn(name = "IdCancion")})
    private List<Cancion> canciones;

    public Playlist() {
        super();
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public int getIdPlaylist() {
        return idPlaylist;
    }

    public void setIdPlaylist(int idPlaylist) {
        this.idPlaylist = idPlaylist;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        return getIdPlaylist();

    }

    @Override
    public String toString() {
        return String.format("PLaylist: %s - %s", getIdPlaylist(), getNombre());
    }

    @Override
    public boolean equals(Object obj) {
        return getIdPlaylist() == ((Playlist) obj).getIdPlaylist();
    }
}
