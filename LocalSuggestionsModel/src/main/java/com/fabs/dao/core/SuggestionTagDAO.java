package com.fabs.dao.core;

import com.fabs.model.core.SuggestionTag;

import java.util.Set;

public interface SuggestionTagDAO {

    void saveOrUpdate(SuggestionTag suggestionTag);

    void saveOrUpdate(Set<SuggestionTag> suggestionTags);

    void delete(Integer id);

    SuggestionTag find(Integer id);
}
