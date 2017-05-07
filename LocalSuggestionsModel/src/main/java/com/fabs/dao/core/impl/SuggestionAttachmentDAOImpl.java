package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.SuggestionAttachmentDAO;
import com.fabs.model.core.SuggestionAttachment;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class SuggestionAttachmentDAOImpl extends AbstractCoreDAO<Long, SuggestionAttachment> implements SuggestionAttachmentDAO {

    public void saveOrUpdate(SuggestionAttachment suggestionAttachment) throws MissingDataException {
        suggestionAttachment.setVersion(suggestionAttachment.getVersion() + 1);
        suggestionAttachment.setUpdateTimestamp(null);
        saveOrUpdateEntity(suggestionAttachment);
    }

    public void saveOrUpdate(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException {
        suggestionAttachments.forEach(suggestionAttachment -> {
            suggestionAttachment.setVersion(suggestionAttachment.getVersion() + 1);
            suggestionAttachment.setUpdateTimestamp(null);
        });
        saveOrUpdateEntity(suggestionAttachments);
    }

    public void delete(SuggestionAttachment suggestionAttachment) throws MissingDataException {
        suggestionAttachment.setDeleted(true);
        saveOrUpdate(suggestionAttachment);
    }

    public void delete(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException {
        suggestionAttachments.forEach(suggestionAttachment -> suggestionAttachment.setDeleted(true));
        saveOrUpdate(suggestionAttachments);
    }
}
