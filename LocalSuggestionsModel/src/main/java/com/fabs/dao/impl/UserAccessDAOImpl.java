package com.fabs.dao.impl;

import com.fabs.dao.UserAccessDAO;
import com.fabs.model.users.UserAccess;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManagerUsers")
public class UserAccessDAOImpl implements UserAccessDAO {

    @Autowired
    @Qualifier(value="sessionFactoryUsers")
    private SessionFactory sessionFactory;

    public void saveOrUpdate(UserAccess userAccess) {
        userAccess.setVersion(userAccess.getVersion()+1);
        userAccess.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(userAccess);
    }

    public UserAccess find(Integer id) {
        return sessionFactory.getCurrentSession().find(UserAccess.class, id);
    }
}
