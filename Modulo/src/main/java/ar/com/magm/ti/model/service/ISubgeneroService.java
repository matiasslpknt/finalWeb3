package ar.com.magm.ti.model.service;

import java.util.List;

import ar.com.magm.ti.model.Subgenero;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface ISubgeneroService extends IGenericService<Subgenero, Integer> {

    public List<Subgenero> list(String parteDelNombre) throws ServiceException;

    public List<Subgenero> listSubgeneros(Integer idGenero) throws ServiceException;
}
