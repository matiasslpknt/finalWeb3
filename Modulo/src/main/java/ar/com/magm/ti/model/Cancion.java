package ar.com.magm.ti.model;

import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.*;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Proxy;

@Entity
@Proxy(lazy = false)
@Access(value = AccessType.FIELD)
@Table(name = "cancion")
public class Cancion implements Serializable, Comparable<Cancion> {

    private static final long serialVersionUID = -3235990393994226233L;

    @Id
    @GeneratedValue
    private int idCancion;

    private String titulo;
    private String duracion;
    private float rating;
    private long reproducciones;
   
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idGenero")
    private Genero genero;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAlbum")
    private Album album;

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
    
    public Cancion() {
        super();
    }

    public int getIdCancion() {
        return idCancion;
    }

    public void setId(int id) {
        this.idCancion = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public long getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(long reproducciones) {
        this.reproducciones = reproducciones;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public int hashCode() {
        return getIdCancion();
    }

    @Override
    public boolean equals(Object obj) {
        Cancion p = (Cancion) obj;
        return getIdCancion() == p.getIdCancion();
    }

    @Override
    public String toString() {
        return String.format("Cancion: titulo=%s, Duracion=%s", getTitulo(), getDuracion());
    }

    @Override
    public int compareTo(Cancion o) {
        // TODO Auto-generated method stub
        String a = new String(String.valueOf(this.getReproducciones()));
        String b = new String(String.valueOf(this.getReproducciones()));
        return a.compareTo(b);
    }
}
