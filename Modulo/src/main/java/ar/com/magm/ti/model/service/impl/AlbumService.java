package ar.com.magm.ti.model.service.impl;

import ar.com.magm.ti.model.Album;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.dao.IAlbumDAO;
import ar.com.magm.ti.model.service.IAlbumService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class AlbumService extends GenericService<Album, Integer>
        implements IAlbumService {

    private static Logger LOG = LoggerFactory.getLogger(AlbumService.class);
    private IAlbumDAO dao;

    public AlbumService(IAlbumDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Album> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
