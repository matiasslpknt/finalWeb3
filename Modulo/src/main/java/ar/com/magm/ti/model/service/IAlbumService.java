package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Album;
import java.util.List;

import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface IAlbumService extends IGenericService<Album, Integer> {

    public List<Album> list(String parteDelNombre) throws ServiceException;
}
