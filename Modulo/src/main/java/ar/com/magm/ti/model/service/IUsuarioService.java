package ar.com.magm.ti.model.service;

import ar.com.magm.ti.model.Concierto;
import java.util.List;

import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;

public interface IUsuarioService extends IGenericService<Usuario, Integer> {

    public List<Usuario> list(String parteDelNombre) throws ServiceException;

    public ArrayList<Concierto> getConciertosEnMiPais(Usuario usuario) throws ServiceException;
}
