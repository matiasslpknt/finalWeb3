package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Genero;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.GeneroDAO;
import ar.com.magm.ti.model.service.IGeneroService;
import ar.com.magm.ti.model.service.impl.GeneroService;
import ar.com.magm.ti.service.exception.ServiceException;
import static org.junit.Assert.assertNotNull;

public class BGeneroTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        Genero p = new Genero();
        p.setNombre("Metal");

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdGenero());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));
        Genero p = new Genero();

        p.setNombre("Trash");

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdGenero());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));
        Genero p = new Genero();
        p.setIdGenero(2);
        p.setNombre("Trash");
        try {
            p = service.update(p);
        } catch (NotFoundException e) {

        }
        assertNotEquals("Se generó mal el id", 0, p.getIdGenero());
    }

    @Test
    public void testList() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> p = service.list();

        assertNotNull("Se generó la lista", p);
    }

    @Test
    public void testListFilter() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        List<Genero> p = service.list("unk");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        Genero p = new Genero();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo el genero");
    }
    /*
    @Test
    public void testDelete()  throws ServiceException{
        IGeneroService service = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));

        Genero p = new Genero();
        try{
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        }catch(NotFoundException e){
        }
        assertNull("Se borro el genero", p);
    }
     */
}
