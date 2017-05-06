package com.fabs.dao.users.impl;

import com.fabs.dao.users.UserDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.*;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public class UserDAOImpl implements UserDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(User user) throws MissingDataException {
        try{
            user.setVersion(user.getVersion() + 1);
            user.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(user);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(user, exception);
        }
    }

    public void delete(User user) throws MissingDataException {
        user.setDeleted(true);
        saveOrUpdate(user);
    }

    public User find(Integer id) throws NotFoundException  {
        User user = sessionFactory.getCurrentSession().find(User.class, id);
        if(user == null)
            throw new NotFoundException(String.format("[User] object with id {0} not found", id));

        return user;
    }

    public Set<User> find(Set<Integer> ids) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);
        Root<User> root = criteria.from(User.class);
        criteria.select(root);
        criteria.where(root.get("id").in(ids));

        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }
}
