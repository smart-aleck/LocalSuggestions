package com.fabs.dao.users.impl;

import com.fabs.dao.users.AccessDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Access;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Repository
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public class AccessDAOImpl implements AccessDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AccessDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Access access) throws MissingDataException {
        try {
            access.setVersion(access.getVersion() + 1);
            access.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(access);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(access, exception);
        }
    }

    public void delete(Access access) throws MissingDataException {
        access.setDeleted(true);
        saveOrUpdate(access);
    }

    public Access find(Integer id) throws NotFoundException {
        Access access = sessionFactory.getCurrentSession().find(Access.class, id);
        if(access == null)
            throw new NotFoundException(String.format("[Access] object with id {0} not found", id));

        return access;
    }
}
