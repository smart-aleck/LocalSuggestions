package com.fabs.dao.core.impl;

import com.fabs.dao.core.SuggestionTagDAO;
import com.fabs.model.core.SuggestionTag;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Set;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class SuggestionTagDAOImpl implements SuggestionTagDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SuggestionTagDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(SuggestionTag suggestionTag) throws MissingDataException {
        try {
            suggestionTag.setVersion(suggestionTag.getVersion() + 1);
            suggestionTag.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(suggestionTag);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(suggestionTag, exception);
        }
    }

    public void saveOrUpdate(Set<SuggestionTag> suggestionTags) throws MissingDataException {
        try {
            for (SuggestionTag suggestionTag : suggestionTags) {
                suggestionTag.setVersion(suggestionTag.getVersion() + 1);
                suggestionTag.setUpdateTimestamp(null);
                sessionFactory.getCurrentSession().saveOrUpdate(suggestionTag);
            }
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(suggestionTags, exception);
        }
    }

    public void delete(SuggestionTag suggestionTag) throws MissingDataException {
        suggestionTag.setDeleted(true);
        saveOrUpdate(suggestionTag);
    }

    public void delete(Set<SuggestionTag> suggestionTags) throws MissingDataException {
        suggestionTags.forEach(suggestionTag -> suggestionTag.setDeleted(true));
        saveOrUpdate(suggestionTags);
    }

    public SuggestionTag find(Long id) throws NotFoundException {
        SuggestionTag suggestionTag = sessionFactory.getCurrentSession().find(SuggestionTag.class, id);
        if(suggestionTag == null)
            throw new NotFoundException(String.format("[SuggestionTag] object with id {0} not found", id));

        return suggestionTag;
    }
}
