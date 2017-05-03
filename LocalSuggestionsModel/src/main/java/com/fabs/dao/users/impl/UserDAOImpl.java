package com.fabs.dao.users.impl;

import com.fabs.dao.users.UserDAO;
import com.fabs.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Repository
@Transactional("transactionManagerUsers")
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(User user) {
        user.setVersion(user.getVersion()+1);
        user.setUpdateTimestamp(null);
        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public void delete(Integer id) {

    }

    public User find(Integer id) {
        return sessionFactory.getCurrentSession().find(User.class, id);
    }

    public Set<User> find(Set<Integer> ids) {
        return null;
    }
}
