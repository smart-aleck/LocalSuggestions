package com.fabs.dao.impl;

import com.fabs.dao.DecorationDAO;
import com.fabs.model.users.Decoration;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManagerUsers")
public class DecorationDAOImpl implements DecorationDAO {

    @Autowired
    @Qualifier(value="sessionFactoryUsers")
    private SessionFactory sessionFactory;

    public void saveOrUpdate(Decoration decoration) {
        decoration.setVersion(decoration.getVersion()+1);
        decoration.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(decoration);
    }

    public Decoration find(Integer id) {
        return sessionFactory.getCurrentSession().find(Decoration.class, id);
    }
}
