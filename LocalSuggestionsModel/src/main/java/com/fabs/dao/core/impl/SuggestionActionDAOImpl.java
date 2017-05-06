package com.fabs.dao.core.impl;

import com.fabs.dao.core.SuggestionActionDAO;
import com.fabs.model.core.SuggestionAction;
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
public class SuggestionActionDAOImpl implements SuggestionActionDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SuggestionActionDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(SuggestionAction suggestionAction) throws MissingDataException {
        try {
            suggestionAction.setVersion(suggestionAction.getVersion() + 1);
            suggestionAction.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(suggestionAction);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(suggestionAction, exception);
        }
    }

    public void delete(SuggestionAction suggestionAction) throws MissingDataException {
        suggestionAction.setDeleted(true);
        saveOrUpdate(suggestionAction);
    }

    public SuggestionAction find(Long id) throws NotFoundException {
        SuggestionAction suggestionAction = sessionFactory.getCurrentSession().find(SuggestionAction.class, id);
        if(suggestionAction == null)
            throw new NotFoundException(String.format("[SuggestionAction] object with id {0} not found", id));

        return suggestionAction;
    }
}
