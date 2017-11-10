package ar.com.magm.ti.model.dao;

import ar.com.magm.ti.model.Concierto;
import java.util.List;

import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IConciertoDAO extends IGenericDAO<Concierto, Integer> {

    public List<Concierto> listPais(String parteDelNombre) throws PersistenceException;

    public List<Concierto> listLugar(String parteDelNombre) throws PersistenceException;

}
