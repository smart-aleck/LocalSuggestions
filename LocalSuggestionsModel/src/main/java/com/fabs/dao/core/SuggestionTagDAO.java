package com.fabs.dao.core;

import com.fabs.model.core.SuggestionTag;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface SuggestionTagDAO {

    void saveOrUpdate(SuggestionTag suggestionTag) throws MissingDataException;

    void saveOrUpdate(Set<SuggestionTag> suggestionTags) throws MissingDataException;

    void delete(SuggestionTag suggestionTag) throws MissingDataException;

    void delete(Set<SuggestionTag> suggestionTags) throws MissingDataException;

    SuggestionTag find(Long id) throws NotFoundException;
}
