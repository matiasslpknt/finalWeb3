package ar.com.magm.ti.model.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.IPlaylistDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class PlaylistDAO extends GenericDAO<Playlist, Integer> implements IPlaylistDAO {

    private static Logger LOG = LoggerFactory.getLogger(PlaylistDAO.class);

    public PlaylistDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Playlist> list(String parteDelNombre) throws PersistenceException {
        List<Playlist> l = null;
        try {
            l = getSession().createQuery("FROM Playlist p WHERE p.nombre LIKE :parteNombre")
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
