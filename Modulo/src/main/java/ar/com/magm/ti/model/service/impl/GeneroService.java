package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Genero;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IGeneroDAO;
import ar.com.magm.ti.model.service.IGeneroService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class GeneroService extends GenericService<Genero, Integer>
        implements IGeneroService {

    private static Logger LOG = LoggerFactory.getLogger(GeneroService.class);
    private IGeneroDAO dao;

    public GeneroService(IGeneroDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Genero> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
