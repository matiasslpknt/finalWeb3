package ar.com.magm.model;

//import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;

import org.hibernate.SessionFactory;
import org.junit.Test;

import ar.com.magm.ti.model.Persona;
import ar.com.magm.ti.model.dao.hibernate.PersonaDAO;
import ar.com.magm.ti.model.service.IPersonaService;
import ar.com.magm.ti.model.service.impl.PersonaService;
import ar.com.magm.ti.service.exception.ServiceException;

public class PersonaTest extends BaseTest {

    @Test
    public void test1() throws ServiceException {
        IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

        Persona p = new Persona();
        p.setApellido("García");
        p.setNombre("Mariano");
        p.setFechaNacimiento(new Date());

        p = service.save(p);
        assertNotEquals("Se generó mal el id", 0, p.getDni());

    }

    @Test
    public void test2() throws ServiceException {
        IPersonaService service = new PersonaService(new PersonaDAO((SessionFactory) sessionFactory()));

        Persona p = new Persona();
        p.setDni(1);
        p.setApellido("Manzanelli");
        p.setNombre("Matias");
        p.setFechaNacimiento(new Date());

        p = service.saveOrUpdate(p);
        assertNotEquals("Se generó mal el id", 0, p.getDni());

    }
}
