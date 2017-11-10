package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Genero;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IGeneroDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class GeneroDAO extends GenericDAO<Genero, Integer> implements IGeneroDAO {

    private static Logger LOG = LoggerFactory.getLogger(GeneroDAO.class);

    public GeneroDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Genero> list(String parteDelNombre) throws PersistenceException {
        List<Genero> l = null;
        try {
            l = getSession().createQuery("FROM Genero p WHERE p.nombre LIKE :parteNombre")
                    .setString("parteNombre", "%" + parteDelNombre + "%").list();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new PersistenceException(e.getMessage(), e);
        } finally {
            closeSession();
        }
        return l;
    }

}
