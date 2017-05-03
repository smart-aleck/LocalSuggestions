package com.fabs.dao.core.impl;

import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional("transactionManager")
public class UserDecorationOverrideDAOImpl implements UserDecorationOverrideDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDecorationOverrideDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(UserDecorationOverride userDecorationOverride) {
        userDecorationOverride.setVersion(userDecorationOverride.getVersion()+1);
        userDecorationOverride.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(userDecorationOverride);
    }

    public void delete(Integer id) {

    }

    public UserDecorationOverride find(Integer id) {
        return sessionFactory.getCurrentSession().find(UserDecorationOverride.class, id);
    }

    public Set<UserDecorationOverride> find(User user) {
        return null;
    }
}
