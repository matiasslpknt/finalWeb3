package ar.com.magm.ti.model.dao;

import ar.com.magm.ti.model.Cancion;
import java.util.List;

import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface ICancionDAO extends IGenericDAO<Cancion, Integer> {

    public List<Cancion> list(String parteDelNombre) throws PersistenceException;

    public List<Cancion> topRating(int limite) throws PersistenceException;

    public List<Cancion> topReproducido(int limite) throws PersistenceException;
}
