package com.fabs.dao.users;

import com.fabs.dao.AbstractDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public abstract class AbstractUsersDAO<PK extends Serializable, T> extends AbstractDAO<PK, T> {

    @Autowired
    @Qualifier("sessionFactoryUsers")
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
}
