package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Artista;
import java.util.List;

import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface IArtistaService extends IGenericService<Artista, Integer> {

    public List<Artista> list(String parteDelNombre) throws ServiceException;
}
