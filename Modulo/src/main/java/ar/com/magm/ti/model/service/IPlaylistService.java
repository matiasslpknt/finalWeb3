package ar.com.magm.ti.model.service;

import java.util.List;

import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface IPlaylistService extends IGenericService<Playlist, Integer> {

    public List<Playlist> list(String parteDelNombre) throws ServiceException;
}
