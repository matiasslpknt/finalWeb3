package ar.com.magm.ti.model.dao;

import ar.com.magm.ti.model.Genero;
import java.util.List;

import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IGeneroDAO extends IGenericDAO<Genero, Integer> {

    public List<Genero> list(String parteDelNombre) throws PersistenceException;
}
