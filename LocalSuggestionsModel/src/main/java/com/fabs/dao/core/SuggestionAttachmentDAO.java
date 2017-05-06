package com.fabs.dao.core;

import com.fabs.model.core.SuggestionAttachment;

import java.util.Set;

public interface SuggestionAttachmentDAO {

    void saveOrUpdate(SuggestionAttachment suggestionAttachment);

    void saveOrUpdate(Set<SuggestionAttachment> suggestionAttachments);

    void delete(Integer id);

    SuggestionAttachment find(Integer id);
}
