package com.fabs.dao.core.impl;

import com.fabs.dao.core.ActionDAO;
import com.fabs.model.core.Action;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class ActionDAOImpl implements ActionDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ActionDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Action action) throws MissingDataException {
        try {
            action.setVersion(action.getVersion() + 1);
            action.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(action);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(action, exception);
        }
    }

    public void delete(Action action) throws MissingDataException {
        action.setDeleted(true);
        saveOrUpdate(action);
    }

    public Action find(Integer id) throws NotFoundException {
        Action action = sessionFactory.getCurrentSession().find(Action.class, id);
        if(action == null)
            throw new NotFoundException(String.format("[Action] object with id {0} not found", id));

        return action;
    }
}
