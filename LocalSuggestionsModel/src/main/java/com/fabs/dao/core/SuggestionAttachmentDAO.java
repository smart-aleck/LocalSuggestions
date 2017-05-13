package com.fabs.dao.core;

import com.fabs.dao.BaseDAO;
import com.fabs.model.core.SuggestionAttachment;
import com.fabs.model.exceptions.MissingDataException;

import java.util.Set;

public interface SuggestionAttachmentDAO extends BaseDAO<Long, SuggestionAttachment> {

    void saveOrUpdate(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException;

    void delete(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException;
}
