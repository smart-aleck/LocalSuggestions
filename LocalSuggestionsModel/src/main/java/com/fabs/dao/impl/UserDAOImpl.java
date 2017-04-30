package com.fabs.dao.impl;

import com.fabs.dao.UserDAO;
import com.fabs.model.users.Decoration;
import com.fabs.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManagerUsers")
public class UserDAOImpl implements UserDAO {

    @Autowired
    @Qualifier(value="sessionFactoryUsers")
    private SessionFactory sessionFactory;

    public void saveOrUpdate(User user) {
        user.setVersion(user.getVersion()+1);
        user.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public User find(Integer id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }
}
