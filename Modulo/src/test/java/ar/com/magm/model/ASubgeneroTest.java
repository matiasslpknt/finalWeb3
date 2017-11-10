package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Subgenero;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.SubgeneroDAO;
import ar.com.magm.ti.model.service.ISubgeneroService;
import ar.com.magm.ti.model.service.impl.SubgeneroService;
import ar.com.magm.ti.service.exception.ServiceException;
import static org.junit.Assert.*;

public class ASubgeneroTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Subgenero p = new Subgenero();
        p.setNombre("Metal");
        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdSubgenero());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        Subgenero p = new Subgenero();
        p.setNombre("Punk");
        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdSubgenero());
    }

    @Test
    public void testUpdate() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Subgenero p = new Subgenero();
        p.setIdSubgenero(2);
        p.setNombre("Nu Metal");
        try {
            p = service.update(p);
        } catch (NotFoundException e) {

        }
        assertNotEquals("Se generó mal el id", 0, p.getIdSubgenero());
    }

    @Test
    public void testList() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        List<Subgenero> p = service.list();

        assertNotNull("No se generó la lista", p);
    }

    @Test
    public void testListFilter() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Subgenero> p = service.list("unk");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        Subgenero p = new Subgenero();
        p = null;
        try {
            p = service.load(1);
            if (!p.getNombre().equals("Metal")) {
                p = null;
            }
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo el Subgenero",p);
    }

    /*
    @Test
    public void testDelete() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Subgenero p = new Subgenero();
        try {
            p = service.load(2);
            service.delete(p);
            p = null;
            p = service.load(2);
        } catch (NotFoundException e) {
        }
        assertNull("Se borro el Subgenero", p);
    }
    
    @Test
    public void testListSubgenero() throws ServiceException {
        ISubgeneroService service = new SubgeneroService(new SubgeneroDAO((SessionFactory) sessionFactory()));

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        List<Subgenero> p = service.listSubgeneros(null);

        assertNotNull("Se generó la lista", p);
    }*/
}
