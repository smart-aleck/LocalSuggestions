package com.fabs.dao.core;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public abstract class AbstractCoreDAO<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    private SessionFactory sessionFactory;

    @Autowired
    @Qualifier("sessionFactory")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    public AbstractCoreDAO(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public void saveOrUpdateEntity(T entity) throws MissingDataException {
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(entity);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(entity, exception);
        }
    }

    public T find(PK key) throws NotFoundException {
        T entity = sessionFactory.getCurrentSession().find(persistentClass, key);
        if(entity == null)
            throw new NotFoundException(String.format("[{0}] object with id {1} not found", persistentClass.toString(), key));

        return entity;
    }
}
