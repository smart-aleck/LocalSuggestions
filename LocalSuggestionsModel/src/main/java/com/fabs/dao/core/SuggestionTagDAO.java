package com.fabs.dao.core;

import com.fabs.dao.BaseDAO;
import com.fabs.model.core.SuggestionTag;
import com.fabs.model.exceptions.MissingDataException;

import java.util.Set;

public interface SuggestionTagDAO extends BaseDAO<Long, SuggestionTag> {

    void saveOrUpdate(Set<SuggestionTag> suggestionTags) throws MissingDataException;

    void delete(Set<SuggestionTag> suggestionTags) throws MissingDataException;
}
