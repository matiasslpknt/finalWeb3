package ar.com.magm.ti.model.dao.hibernate;

import ar.com.magm.ti.model.Album;
import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IAlbumDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class AlbumDAO extends GenericDAO<Album, Integer> implements IAlbumDAO {

    private static Logger LOG = LoggerFactory.getLogger(AlbumDAO.class);

    public AlbumDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Album> list(String parteDelNombre) throws PersistenceException {
        List<Album> l = null;
        try {
            l = getSession().createQuery("FROM Album p WHERE p.nombre LIKE :parteNombre")
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
