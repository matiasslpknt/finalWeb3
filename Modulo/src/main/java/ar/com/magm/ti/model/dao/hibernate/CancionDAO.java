package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Cancion;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.ICancionDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class CancionDAO extends GenericDAO<Cancion, Integer> implements ICancionDAO {

    private static Logger LOG = LoggerFactory.getLogger(CancionDAO.class);

    public CancionDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cancion> list(String parteDelNombre) throws PersistenceException {
        List<Cancion> l = null;
        try {
            l = getSession().createQuery("FROM Cancion p WHERE p.titulo LIKE :parteNombre")
                    .setString("parteNombre", "%" + parteDelNombre + "%").list();
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new PersistenceException(e.getMessage(), e);
        } finally {
            closeSession();
        }
        return l;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cancion> topRating(int limite) throws PersistenceException {

        List<Cancion> l = null;

        try {/*
			
			l = getSession().createQuery("from Cancion").list();
             */
            Query q = getSession().createQuery("FROM Cancion c ORDER BY c.rating desc");
            q.setFirstResult(1);
            q.setMaxResults(limite);
            l = q.list();

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new PersistenceException(e.getMessage(), e);
        } finally {
            closeSession();
        }
        return l;
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Cancion> topReproducido(int limite) throws PersistenceException {
        List<Cancion> l = null;

        try {/*
			
			l = getSession().createQuery("from Cancion").list();
             */
            Query q = getSession().createQuery("FROM Cancion c ORDER BY c.reproducciones desc");
            q.setFirstResult(1);
            q.setMaxResults(limite);
            l = q.list();

        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            throw new PersistenceException(e.getMessage(), e);
        } finally {
            closeSession();
        }
        return l;
    }

}
