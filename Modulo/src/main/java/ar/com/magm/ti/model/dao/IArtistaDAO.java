package ar.com.magm.ti.model.dao;

import ar.com.magm.ti.model.Artista;
import java.util.List;

import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IArtistaDAO extends IGenericDAO<Artista, Integer> {

    public List<Artista> list(String parteDelNombre) throws PersistenceException;
}
