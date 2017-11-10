package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Concierto;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IConciertoDAO;
import ar.com.magm.ti.model.service.IConciertoService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class ConciertoService extends GenericService<Concierto, Integer>
        implements IConciertoService {

    private static Logger LOG = LoggerFactory.getLogger(ConciertoService.class);
    private IConciertoDAO dao;

    public ConciertoService(IConciertoDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Concierto> listPais(String parteDelNombre) throws ServiceException {
        try {
            return dao.listPais(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public List<Concierto> listLugar(String parteDelNombre) throws ServiceException {
        try {
            return dao.listPais(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
