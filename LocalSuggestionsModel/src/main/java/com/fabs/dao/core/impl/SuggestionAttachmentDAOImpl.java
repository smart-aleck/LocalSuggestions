package com.fabs.dao.core.impl;

import com.fabs.dao.core.SuggestionAttachmentDAO;
import com.fabs.model.core.SuggestionAttachment;
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
public class SuggestionAttachmentDAOImpl implements SuggestionAttachmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public SuggestionAttachmentDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(SuggestionAttachment suggestionAttachment) throws MissingDataException {
        try {
            suggestionAttachment.setVersion(suggestionAttachment.getVersion() + 1);
            suggestionAttachment.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(suggestionAttachment);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(suggestionAttachment, exception);
        }
    }

    public void saveOrUpdate(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException {
        try {
            for (SuggestionAttachment suggestionAttachment : suggestionAttachments) {
                suggestionAttachment.setVersion(suggestionAttachment.getVersion() + 1);
                suggestionAttachment.setUpdateTimestamp(null);
                sessionFactory.getCurrentSession().saveOrUpdate(suggestionAttachment);
            }
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(suggestionAttachments, exception);
        }
    }

    public void delete(SuggestionAttachment suggestionAttachment) throws MissingDataException {
        suggestionAttachment.setDeleted(true);
        saveOrUpdate(suggestionAttachment);
    }

    public void delete(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException {
        suggestionAttachments.forEach(suggestionAttachment -> suggestionAttachment.setDeleted(true));
        saveOrUpdate(suggestionAttachments);
    }

    public SuggestionAttachment find(Long id) throws NotFoundException {
        SuggestionAttachment suggestionAttachment = sessionFactory.getCurrentSession().find(SuggestionAttachment.class, id);
        if(suggestionAttachment == null)
            throw new NotFoundException(String.format("[SuggestionAttachment] object with id {0} not found", id));

        return suggestionAttachment;
    }
}
