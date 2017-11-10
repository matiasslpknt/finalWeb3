package ar.com.magm.ti.model.dao.hibernate;

import java.util.List;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.IUsuarioDAO;
import ar.com.magm.ti.persistence.dao.hibernate.GenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;

public class UsuarioDAO extends GenericDAO<Usuario, Integer> implements IUsuarioDAO {

    private static Logger LOG = LoggerFactory.getLogger(UsuarioDAO.class);

    public UsuarioDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Usuario> list(String parteDelNombre) throws PersistenceException {
        List<Usuario> l = null;
        try {
            l = getSession().createQuery("FROM Usuario p WHERE p.usuario LIKE :parteNombre")
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
