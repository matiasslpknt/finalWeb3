package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Cancion;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.ICancionDAO;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class CancionService extends GenericService<Cancion, Integer>
        implements ICancionService {

    private static Logger LOG = LoggerFactory.getLogger(CancionService.class);
    private ICancionDAO dao;

    public CancionService(ICancionDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Cancion> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Cancion> topRating(int limite) throws ServiceException {
        try {
            return dao.topRating(limite);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Cancion> topReproducido(int limite) throws ServiceException {
        try {
            return dao.topReproducido(limite);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
