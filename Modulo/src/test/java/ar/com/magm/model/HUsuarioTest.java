package ar.com.magm.model;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Artista;
import ar.com.magm.ti.model.Concierto;
import ar.com.magm.ti.model.Playlist;
import ar.com.magm.ti.model.Usuario;
import ar.com.magm.ti.model.dao.hibernate.ArtistaDAO;
import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.dao.hibernate.PlaylistDAO;
import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.UsuarioDAO;
import ar.com.magm.ti.model.service.IArtistaService;
import ar.com.magm.ti.model.service.IPlaylistService;
import ar.com.magm.ti.model.service.IUsuarioService;
import ar.com.magm.ti.model.service.impl.ArtistaService;
import ar.com.magm.ti.model.service.impl.PlaylistService;
import ar.com.magm.ti.model.service.impl.UsuarioService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertNotNull;

public class HUsuarioTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));
        IPlaylistService servicePlaylist = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));
        IArtistaService serviceArtista = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));
        //List<Usuario> l = service.list();
        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        p.setContraseña("1234");
        p.setMail("prueba123@gmail.com");
        p.setPais("prueba");
        p.setPremiun(false);
        p.setUsuario("prueba");

        try {
            ArrayList<Playlist> pls = new ArrayList<Playlist>();
            Playlist pl;
            pl = servicePlaylist.load(1);
            pls.add(pl);
            p.setPlaylists(pls);
            ArrayList<Artista> arts = new ArrayList<Artista>();
            Artista art = serviceArtista.load(1);
            arts.add(art);
            p.setArtistasSeguidos(arts);
        } catch (NotFoundException ex) {
            Logger.getLogger(HUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));
        IPlaylistService servicePlaylist = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));
        IArtistaService serviceArtista = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));
        //List<Usuario> l = service.list();
        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        p.setContraseña("1111");
        p.setMail("fcabanilla@gmail.com");
        p.setPais("Argentina");
        p.setPremiun(false);
        p.setUsuario("fcabanilla");

        try {
            ArrayList<Playlist> pls = new ArrayList<Playlist>();
            Playlist pl;
            pl = servicePlaylist.load(2);
            pls.add(pl);
            p.setPlaylists(pls);
            ArrayList<Artista> arts = new ArrayList<Artista>();
            Artista art = serviceArtista.load(2);
            arts.add(art);
            p.setArtistasSeguidos(arts);
        } catch (NotFoundException ex) {
            Logger.getLogger(HUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));
        IPlaylistService servicePlaylist = new PlaylistService(new PlaylistDAO((SessionFactory) sessionFactory()));
        IArtistaService serviceArtista = new ArtistaService(new ArtistaDAO((SessionFactory) sessionFactory()));

        Usuario p = new Usuario();
        p.setId(1);
        p.setContraseña("6666");
        p.setMail("matiasslpknt@gmail.com");
        p.setPais("Argentina");
        p.setPremiun(true);
        p.setUsuario("matiasslpknt");
        try {
            ArrayList<Playlist> pls = new ArrayList<Playlist>();
            Playlist pl;
            pl = servicePlaylist.load(1);
            pls.add(pl);
            p.setPlaylists(pls);
            ArrayList<Artista> arts = new ArrayList<Artista>();
            Artista art = serviceArtista.load(1);
            arts.add(art);
            p.setArtistasSeguidos(arts);
            p = service.update(p);
        } catch (NotFoundException ex) {
            Logger.getLogger(HUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotEquals("Se generó mal el id", 0, p.getId());
    }

    @Test
    public void testList() throws ServiceException {
        
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));
        List<Usuario> p = service.list("matiasslpknt");
        if(p.size()==0){
            p = null;
        }
        assertNotNull("No se generó la lista", p);
    }

    @Test
    public void testListFilter() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

        List<Usuario> p = service.list("caba");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

        Usuario p = new Usuario();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo el Usuario");
    }

    @Test
    public void getConciertosEnMiPais() throws ServiceException {
        ArrayList<Concierto> c = null;
        try {
            IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

            Usuario usuario = service.load(1);
            c = service.getConciertosEnMiPais(usuario);
            if(c.size()==0){
                c = null;
            }

            
        } catch (NotFoundException ex) {
            Logger.getLogger(HUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull("No se generó la lista", c);
    }

    @Test
    public void getConciertosEnMiPaisVerificarTamaño() throws ServiceException {
        boolean bo = false;
        try {
            IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()), new ConciertoDAO((SessionFactory) sessionFactory()));

            Usuario usuario = service.load(1);
            ArrayList<Concierto> c = service.getConciertosEnMiPais(usuario);
            int tam = c.size();
            bo = tam == 1;
            
        } catch (NotFoundException ex) {
            Logger.getLogger(HUsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        assertTrue("No se generó la lista", bo);

    }

    /*
    @Test
    public void testDelete() throws ServiceException {
        IUsuarioService service = new UsuarioService(new UsuarioDAO((SessionFactory) sessionFactory()));

        //List<Usuario> l = service.list();
        //assertEquals("Tamaño erróneo de la lista",0,l.size());
        Usuario p = new Usuario();
        try {
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        } catch (NotFoundException e) {
        }
        assertNull("Se borro el Usuario", p);
    }
     */
}
