package com.fabs.dao.impl;

import com.fabs.dao.UserDecorationDAO;
import com.fabs.model.users.UserDecoration;
import com.fabs.model.users.UserDecorationPK;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManagerUsers")
public class UserDecorationDAOImpl implements UserDecorationDAO {

    @Autowired
    @Qualifier(value="sessionFactoryUsers")
    private SessionFactory sessionFactory;

    public void saveOrUpdate(UserDecoration userDecoration) {
        userDecoration.setVersion(userDecoration.getVersion()+1);
        userDecoration.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(userDecoration);
    }

    public UserDecoration find(UserDecorationPK userDecorationPK) {
        return sessionFactory.getCurrentSession().find(UserDecoration.class, userDecorationPK);
    }
}
