package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Genero;

import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import ar.com.magm.ti.model.dao.hibernate.GeneroDAO;

import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.IGeneroService;

import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.model.service.impl.GeneroService;

import ar.com.magm.ti.service.exception.ServiceException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;

public class CCancionTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        IGeneroService serviceGenero = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));
        Cancion p = new Cancion();
        p.setTitulo("Before I forguet");
        p.setDuracion("3'45''");
        p.setRating((float) 4.5);
        p.setReproducciones(15);
        try {
            Genero f = serviceGenero.load(1);
            p = service.save(p);

        } catch (NotFoundException ex) {
            Logger.getLogger(CCancionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotEquals("Se generó mal el id", 0, p.getIdCancion());
    }

    @Test
    public void testList() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> p = service.list();

        assertNotNull("Se generó la lista");
    }

    @Test
    public void testListFilter() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> p = service.list("the");

        assertNotNull("No se generó la lista");
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        Cancion p = new Cancion();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo la cancion");
    }

    @Test
    public void testUpdate() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        IGeneroService serviceGenero = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));
        Cancion p = new Cancion();
        p.setId(1);
        p.setDuracion("9'11''");
        p.setRating((float) 4.1);
        p.setReproducciones(33);
        p.setTitulo("Smell like teen spirit");
        try {
            Genero f = serviceGenero.load(2);
            p.setGenero(f);
            p = service.update(p);
        } catch (NotFoundException ex) {
            Logger.getLogger(CCancionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotEquals("Se generó mal el id", 0, p.getIdCancion());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        IGeneroService serviceGenero = new GeneroService(new GeneroDAO((SessionFactory) sessionFactory()));
        Cancion p = new Cancion();
        p.setDuracion("7'22''");
        p.setRating((float) 3.2);
        p.setReproducciones(9);
        p.setTitulo("Pulse of the maggot");
        try {
            Genero f = serviceGenero.load(1);
            p.setGenero(f);
            p = service.saveOrUpdate(p);
        } catch (NotFoundException ex) {
            Logger.getLogger(CCancionTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotEquals("Se generó mal el id", 0, p.getIdCancion());
    }

    /*
    
    @Test
    public void testDelete() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        //List<Cancion> l = service.list();
        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Cancion p = new Cancion();
        try {
            p = service.load(2);
            service.delete(p);
            p = null;
            p = service.load(2);
        } catch (NotFoundException e) {
        }
        assertNull("Se borro la cancion", p);
    }
     */
    @Test
    public void testTopRating() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> p = service.topRating(5);

        assertNotNull("Se generó la lista", p);
    }

    @Test
    public void testTopReproducido() throws ServiceException {
        ICancionService service = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        List<Cancion> p = service.topReproducido(5);

        assertNotNull("Se generó la lista", p);
    }

}
