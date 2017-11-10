package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Artista;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IArtistaDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class ArtistaService extends GenericService<Artista, Integer>
        implements IArtistaService {

    private static Logger LOG = LoggerFactory.getLogger(ArtistaService.class);
    private IArtistaDAO dao;

    public ArtistaService(IArtistaDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Artista> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
