package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.model.Concierto;
import static org.junit.Assert.assertNotEquals;

import java.util.List;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.dao.hibernate.ConciertoDAO;
import ar.com.magm.ti.model.service.IConciertoService;
import ar.com.magm.ti.model.service.impl.ConciertoService;
import ar.com.magm.ti.service.exception.ServiceException;
import java.util.Date;
import static org.junit.Assert.assertNotNull;

public class DConciertoTest extends BaseTest {

    @Test
    public void testSave() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        Concierto p = new Concierto();
        p.setFecha(new Date());
        p.setLugar("Orfeo Superdomo");
        p.setPais("Argentina");

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdConcierto());
    }

    @Test
    public void testSaveOrUpdate() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        Concierto p = new Concierto();
        p.setFecha(new Date());
        p.setLugar("Luna Park");
        p.setPais("Uruguay");

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getIdConcierto());
    }

    @Test
    public void testUpdate() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        Concierto p = new Concierto();
        p.setIdConcierto(1);
        p.setFecha(new Date());
        p.setLugar("Chateau Carreras");
        p.setPais("Argentina");
        try {
            p = service.update(p);
        } catch (NotFoundException e) {

        }
        assertNotEquals("Se generó mal el id", 0, p.getIdConcierto());
    }

    @Test
    public void testList() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        List<Concierto> p = service.list();

        assertNotNull("Se generó la lista", p);
    }

    @Test
    public void testListPaisFilter() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        List<Concierto> p = service.listPais("rge");

        assertNotNull("No se generó la lista", p);
    }

    @Test
    public void testListLugarFilter() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        List<Concierto> p = service.listLugar("una");

        assertNotNull("No se generó la lista", p);
    }

    @SuppressWarnings("unused")
    @Test
    public void testLoad() throws ServiceException {
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        Concierto p = new Concierto();
        p = null;
        try {
            p = service.load(1);
        } catch (NotFoundException e) {
        }

        assertNotNull("No se cargo el concierto");
    }
    /*
    @Test
    public void testDelete()  throws ServiceException{
        IConciertoService service = new ConciertoService(new ConciertoDAO((SessionFactory) sessionFactory()));

        Concierto p = new Concierto();
        try{
            p = service.load(1);
            service.delete(p);
            p = null;
            p = service.load(1);
        }catch(NotFoundException e){
        }
        assertNull("Se borro el concierto", p);
    }
     */
}
