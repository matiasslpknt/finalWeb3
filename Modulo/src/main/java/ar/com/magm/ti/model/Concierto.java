package ar.com.magm.ti.model;

import java.io.Serializable;
import java.util.Date;

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
@Table(name = "concierto")
public class Concierto implements Serializable {

    private static final long serialVersionUID = 2464927409480955012L;
    @Id
    @GeneratedValue
    private int idConcierto;

    private String pais;
    private String lugar;
    private Date fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idArtista")
    private Artista artista;

    public Concierto() {
        super();
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getIdConcierto() {
        return idConcierto;
    }

    public void setIdConcierto(int idConcierto) {
        this.idConcierto = idConcierto;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }
    @Override
    public int hashCode() {
        return getIdConcierto();

    }

    @Override
    public String toString() {
        return String.format("Concierto: %s Pais: %s", getIdConcierto(), getPais());
    }

    @Override
    public boolean equals(Object obj) {
        return getIdConcierto() == ((Concierto) obj).getIdConcierto();
    }
}
