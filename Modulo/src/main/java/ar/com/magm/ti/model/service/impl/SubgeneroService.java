package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.model.dao.ISubgeneroDAO;
import ar.com.magm.ti.model.service.ISubgeneroService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class SubgeneroService extends GenericService<Subgenero, Integer>
        implements ISubgeneroService {

    private static Logger LOG = LoggerFactory.getLogger(SubgeneroService.class);
    private ISubgeneroDAO dao;

    public SubgeneroService(ISubgeneroDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Subgenero> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Subgenero> listSubgeneros(Integer idGenero) throws ServiceException {
        try {
            return dao.listSubgeneros(idGenero);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
