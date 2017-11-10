package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Concierto;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IConciertoDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class ConciertoDAO extends GenericDAO<Concierto, Integer> implements IConciertoDAO {

    private static Logger LOG = LoggerFactory.getLogger(ConciertoDAO.class);

    public ConciertoDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    //@SuppressWarnings("unchecked")
    @Override
    public List<Concierto> listPais(String parteDelNombre) throws PersistenceException {
        List<Concierto> l = null;
        try {
            l = getSession().createQuery("FROM Concierto p WHERE p.pais LIKE :parteNombre")
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
    public List<Concierto> listLugar(String parteDelNombre) throws PersistenceException {
        List<Concierto> l = null;
        try {
            l = getSession().createQuery("FROM Concierto p WHERE p.lugar LIKE :parteNombre")
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
