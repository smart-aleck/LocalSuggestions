package com.fabs.dao.impl;

import com.fabs.dao.UserDecorationOverrideDAO;
import com.fabs.model.core.UserDecorationOverride;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManager")
public class UserDecorationOverrideDAOImpl implements UserDecorationOverrideDAO {

    @Autowired
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;

    public void saveOrUpdate(UserDecorationOverride userDecorationOverride) {
        userDecorationOverride.setVersion(userDecorationOverride.getVersion()+1);
        userDecorationOverride.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(userDecorationOverride);
    }

    public UserDecorationOverride find(Integer id) {
        return sessionFactory.getCurrentSession().find(UserDecorationOverride.class, id);
    }
}
