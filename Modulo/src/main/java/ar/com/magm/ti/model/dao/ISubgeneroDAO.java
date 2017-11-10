package ar.com.magm.ti.model.dao;

import java.util.List;

import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface ISubgeneroDAO extends IGenericDAO<Subgenero, Integer> {

    public List<Subgenero> list(String parteDelNombre) throws PersistenceException;

    public List<Subgenero> listSubgeneros(Integer idGenero) throws PersistenceException;
}
