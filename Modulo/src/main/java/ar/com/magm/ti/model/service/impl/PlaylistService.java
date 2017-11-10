package ar.com.magm.ti.model.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.IPlaylistDAO;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.exception.ServiceException;
import ar.com.magm.ti.service.impl.GenericService;

public class PlaylistService extends GenericService<Playlist, Integer>
        implements IPlaylistService {

    private static Logger LOG = LoggerFactory.getLogger(PlaylistService.class);
    private IPlaylistDAO dao;

    public PlaylistService(IPlaylistDAO dao) {
        super(dao);
        this.dao = dao;
    }

    @Override
    public List<Playlist> list(String parteDelNombre) throws ServiceException {
        try {
            return dao.list(parteDelNombre);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

}
