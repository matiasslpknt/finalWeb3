package ar.com.magm.ti.model.dao;

import ar.com.magm.ti.model.Album;
import java.util.List;

import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IAlbumDAO extends IGenericDAO<Album, Integer> {

    public List<Album> list(String parteDelNombre) throws PersistenceException;
}
