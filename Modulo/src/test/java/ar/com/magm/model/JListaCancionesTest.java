/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.magm.model;

import ar.com.magm.ti.model.Cancion;
import org.junit.Test;

import ar.com.magm.ti.model.service.impl.ListaCancionesService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.ArrayList;
import static org.junit.Assert.*;

/**
 *
 * @author matia
 */
public class JListaCancionesTest extends BaseTest {

    @Test
    public void testGetDuracionTotalLsta() throws ServiceException {
        ListaCancionesService service = new ListaCancionesService();
        ArrayList<Cancion> canciones = new ArrayList();
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
        Cancion c3 = new Cancion();
        c1.setDuracion("74'1''");
        c2.setDuracion("1'20''");
        c3.setDuracion("30240'0''");
        canciones.add(c1);
        canciones.add(c2);
        canciones.add(c3);
        String str = service.getDuracionTotalLista(canciones);
        assertEquals("Se genero la duracion total de la lista.", "3w0d25h15m21s", str);
    }

    @Test
    public void testOrdenarCancionesPorDuracion() throws ServiceException {
        ListaCancionesService service = new ListaCancionesService();
        ArrayList<Cancion> canciones = new ArrayList();
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
        Cancion c3 = new Cancion();
        c1.setDuracion("74'1''");
        c2.setDuracion("1'20''");
        c3.setDuracion("30240'0''");
        canciones.add(c1);
        canciones.add(c2);
        canciones.add(c3);
        ArrayList<Cancion> cancs = service.ordenarCancionPorDuracion(canciones);
        assertNotNull("Se ordeno correctamente.", cancs);
    }

    @Test
    public void testComprobarTamañoListas() throws ServiceException {
        ListaCancionesService service = new ListaCancionesService();
        ArrayList<Cancion> canciones = new ArrayList();
        Cancion c1 = new Cancion();
        Cancion c2 = new Cancion();
        Cancion c3 = new Cancion();
        c1.setDuracion("74'1''");
        c2.setDuracion("1'20''");
        c3.setDuracion("30240'0''");
        canciones.add(c1);
        canciones.add(c2);
        canciones.add(c3);
        int tamanio1 = canciones.size();
        ArrayList<Cancion> cancs = service.ordenarCancionPorDuracion(canciones);
        int tamanio2 = cancs.size();
        boolean test = false;
        if (tamanio1 == tamanio2) {
            test = true;
        }
        assertTrue("Se rdeno correctamente.", test);
    }
}
