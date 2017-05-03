package com.fabs.dao.users.impl;

import com.fabs.dao.users.AccessDAO;
import com.fabs.model.users.Access;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManagerUsers")
public class AccessDAOImpl implements AccessDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AccessDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Access access) {
        access.setVersion(access.getVersion()+1);
        access.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(access);
    }

    public void delete(Integer id) {

    }

    public Access find(Integer id) {
        return sessionFactory.getCurrentSession().find(Access.class, id);
    }
}
