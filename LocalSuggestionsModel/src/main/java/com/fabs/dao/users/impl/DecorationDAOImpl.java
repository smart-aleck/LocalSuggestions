package com.fabs.dao.users.impl;

import com.fabs.dao.users.DecorationDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Decoration;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public class DecorationDAOImpl implements DecorationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public DecorationDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Decoration decoration) throws MissingDataException {
        try {
            decoration.setVersion(decoration.getVersion() + 1);
            decoration.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(decoration);
        }
        catch(ConstraintViolationException exception){
            throw new MissingDataException(decoration, exception);
        }
    }

    public void delete(Decoration decoration) throws MissingDataException {
        try {
            decoration.setDeleted(true);
            saveOrUpdate(decoration);
        }
        catch(ConstraintViolationException exception){
            throw new MissingDataException(decoration, exception);
        }
    }

    public Decoration find(Integer id) throws NotFoundException {
        Decoration decoration = sessionFactory.getCurrentSession().find(Decoration.class, id);
        if(decoration == null)
            throw new NotFoundException(String.format("[Decoration] object with id {0} not found", id));

        return decoration;
    }
}
