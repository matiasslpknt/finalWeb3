package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Concierto;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.IConciertoDAO;
import ar.com.magm.ti.model.dao.IUsuarioDAO;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;
import java.util.ArrayList;
import java.util.logging.Level;

public class UsuarioService extends GenericService<Usuario, Integer>
        implements IUsuarioService {

    private static Logger LOG = LoggerFactory.getLogger(UsuarioService.class);
    private IUsuarioDAO dao;
    private IConciertoDAO daoConcierto;

    public UsuarioService(IUsuarioDAO dao, IConciertoDAO daoConcierto) {
        super(dao);
        this.dao = dao;
        this.daoConcierto = daoConcierto;
    }

    @Override
    public List<Usuario> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public ArrayList<Concierto> getConciertosEnMiPais(Usuario usuario) throws ServiceException {
        ArrayList<Concierto> cons = new ArrayList<Concierto>();
        ArrayList<Concierto> aux = new ArrayList<Concierto>();
        try {
            aux = (ArrayList<Concierto>)daoConcierto.list();
            for (Concierto c : aux) {
                if (c.getPais().equals(usuario.getPais())) {
                    cons.add(c);
                }
            }
        } catch (PersistenceException ex) {
            java.util.logging.Logger.getLogger(UsuarioService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cons;
    }
}
