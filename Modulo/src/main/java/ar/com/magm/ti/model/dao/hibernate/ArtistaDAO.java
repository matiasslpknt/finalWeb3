package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Artista;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IArtistaDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class ArtistaDAO extends GenericDAO<Artista, Integer> implements IArtistaDAO {

    private static Logger LOG = LoggerFactory.getLogger(ArtistaDAO.class);

    public ArtistaDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Artista> list(String parteDelNombre) throws PersistenceException {
        List<Artista> l = null;
        try {
            l = getSession().createQuery("FROM Artista p WHERE p.nombre LIKE :parteNombre")
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
