package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Genero;
import java.util.List;

import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

public interface IGeneroService extends IGenericService<Genero, Integer> {

    public List<Genero> list(String parteDelNombre) throws ServiceException;
}
