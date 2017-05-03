package com.fabs.dao.users.impl;

import com.fabs.dao.users.DecorationDAO;
import com.fabs.model.users.Decoration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManagerUsers")
public class DecorationDAOImpl implements DecorationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public DecorationDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Decoration decoration) {
        decoration.setVersion(decoration.getVersion()+1);
        decoration.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(decoration);
    }

    public void delete(Integer id) {

    }

    public Decoration find(Integer id) {
        return sessionFactory.getCurrentSession().find(Decoration.class, id);
    }
}
