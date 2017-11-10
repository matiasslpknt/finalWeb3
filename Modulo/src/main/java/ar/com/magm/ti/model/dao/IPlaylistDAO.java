package ar.com.magm.ti.model.dao;

import java.util.List;

import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IPlaylistDAO extends IGenericDAO<Playlist, Integer> {

    public List<Playlist> list(String parteDelNombre) throws PersistenceException;
}
