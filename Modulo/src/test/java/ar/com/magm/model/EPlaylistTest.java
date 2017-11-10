package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Cancion;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.dao.hibernate.CancionDAO;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.PlaylistDAO;
import ar.com.magm.ti.model.service.ICancionService;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.model.service.impl.CancionService;
import ar.com.magm.ti.model.service.impl.PlaylistService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;

public class EPlaylistTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));
        ICancionService serviceCancion = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));

        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        Cancion c = new Cancion();
        p.setNombre("Clasica");
        try {
            ArrayList<Cancion> canciones = new ArrayList<Cancion>();
            c = serviceCancion.load(1);
            canciones.add(c);
            p.setCanciones(canciones);
        } catch (NotFoundException ex) {
            Logger.getLogger(EPlaylistTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdPlaylist());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));
        ICancionService serviceCancion = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Playlist p = new Playlist();
        p.setNombre("Punk");
        Cancion c = new Cancion();
        try {
            ArrayList<Cancion> canciones = new ArrayList<Cancion>();
            c = serviceCancion.load(1);
            canciones.add(c);
            p.setCanciones(canciones);
        } catch (NotFoundException ex) {
            Logger.getLogger(EPlaylistTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdPlaylist());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));
        ICancionService serviceCancion = new CancionService(new CancionDAO((SessionFactory) sessionFactory()));
        Playlist p = new Playlist();
        p.setIdPlaylist(1);
        p.setCanciones(new ArrayList<Cancion>());
        p.setNombre("Metal");
        Cancion c = new Cancion();
        try {
            ArrayList<Cancion> canciones = new ArrayList<Cancion>();
            c = serviceCancion.load(2);
            canciones.add(c);
            p.setCanciones(canciones);
            p = service.update(p);
        } catch (NotFoundException ex) {
            Logger.getLogger(EPlaylistTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        assertNotEquals("Se generó mal el id", 0, p.getIdPlaylist());
    }

    @Test
    public void testList() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> p = service.list();

        assertNotNull("Se generó la lista", p);
    }

    @Test
    public void testListFilter() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        List<Playlist> p = service.list("unk");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        Playlist p = new Playlist();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo la Playlist");
    }/*
    @Test
    public void testDelete() throws ServiceException {
        IPlaylistService service = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));

        Playlist p = new Playlist();
        try {
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        } catch (NotFoundException e) {
        }
        assertNull("Se borro la Playlist", p);
    }
     */
}
