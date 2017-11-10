package ar.com.magm.ti.model.dao;

import java.util.List;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public interface IUsuarioDAO extends IGenericDAO<Usuario, Integer> {

    public List<Usuario> list(String parteDelNombre) throws PersistenceException;
}
