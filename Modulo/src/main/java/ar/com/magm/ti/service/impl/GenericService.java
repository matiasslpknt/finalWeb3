package ar.com.magm.ti.service.impl;

import java.io.Serializable;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.magm.ti.exception.NotFoundException;
import ar.com.magm.ti.persistence.dao.IGenericDAO;
import ar.com.magm.ti.persistence.exception.PersistenceException;
import ar.com.magm.ti.service.IGenericService;
import ar.com.magm.ti.service.exception.ServiceException;

/**
 *
 * @author magm
 *
 * @param <Entity>
 * @param <PK>
 */
public class GenericService<Entity, PK extends Serializable> implements IGenericService<Entity, PK> {

    private static Logger LOG = LoggerFactory.getLogger(GenericService.class);
    private IGenericDAO<Entity, PK> dao;

    @SuppressWarnings({"unchecked", "rawtypes"})
    public GenericService(IGenericDAO dao) {
        this.dao = dao;
    }

    @Override
    public void delete(Entity entity) throws ServiceException, NotFoundException {
        try {
            dao.delete(entity);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }

    }

    @Override
    public List<Entity> list() throws ServiceException {
        try {
            return dao.list();
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Entity load(PK id) throws ServiceException, NotFoundException {
        try {
            return dao.load(id);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Entity save(Entity entity) throws ServiceException {
        try {
            return dao.save(entity);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Entity saveOrUpdate(Entity entity) throws ServiceException {
        try {
            return dao.saveOrUpdate(entity);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }

    @Override
    public Entity update(Entity entity) throws ServiceException, NotFoundException {
        try {
            return dao.update(entity);
        } catch (PersistenceException e) {
            LOG.error(e.getMessage(), e);
            throw new ServiceException(e.getMessage(), e);
        }
    }
}
