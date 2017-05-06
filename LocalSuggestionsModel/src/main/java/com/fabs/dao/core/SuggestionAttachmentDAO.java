package com.fabs.dao.core;

import com.fabs.model.core.SuggestionAttachment;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface SuggestionAttachmentDAO {

    void saveOrUpdate(SuggestionAttachment suggestionAttachment) throws MissingDataException;

    void saveOrUpdate(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException;

    void delete(SuggestionAttachment suggestionAttachment) throws MissingDataException;

    void delete(Set<SuggestionAttachment> suggestionAttachments) throws MissingDataException;

    SuggestionAttachment find(Long id) throws NotFoundException;
}
