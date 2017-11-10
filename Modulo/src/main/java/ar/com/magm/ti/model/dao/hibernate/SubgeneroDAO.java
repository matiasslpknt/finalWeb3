package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.model.dao.ISubgeneroDAO;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class SubgeneroDAO extends GenericDAO<Subgenero, Integer> implements ISubgeneroDAO {

    private static Logger LOG = LoggerFactory.getLogger(SubgeneroDAO.class);

    public SubgeneroDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Subgenero> list(String parteDelNombre) throws PersistenceException {
        List<Subgenero> l = null;
        try {
            l = getSession().createQuery("FROM Subgenero p WHERE p.nombre LIKE :parteNombre")
                    .setString("parteNombre", "%" + parteDelNombre + "%").list();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new PersistenceException(e.getMessage(), e);
        } finally {
            closeSession();
        }
        return l;
    }

    @Override
    public List<Subgenero> listSubgeneros(Integer idGenero) throws PersistenceException {
        List<Subgenero> l = null;
        try {
            l = getSession().createQuery("FROM Subgenero p WHERE p.idGenero=" + idGenero).list();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new PersistenceException(e.getMessage(), e);
        } finally {
            closeSession();
        }
        return l;
    }

}
