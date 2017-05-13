package com.fabs.dao.core;

import com.fabs.dao.AbstractDAO;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional(value = "transactionManagerCore", rollbackFor = Exception.class)
public abstract class AbstractCoreDAO<PK extends Serializable, T> extends AbstractDAO<PK, T> {

    @Autowired
    @Qualifier("sessionFactoryCore")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    // We cannot use the one in AbstractDAO directly as the 'Transactional' tag is required on the
    // class where Hibernate calls are initiated. i.e. we need to initiate the calls in either the
    // AbstractCoreDAO class or the DAOImpl classes
    public T find(PK key) throws NotFoundException {
        return findEntity(key);
    }
    public Long count(){
        return rowCount();
    }
}
