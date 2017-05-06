package com.fabs.dao.core;

import com.fabs.model.core.SuggestionAction;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

public interface SuggestionActionDAO {

    void saveOrUpdate(SuggestionAction suggestionAction) throws MissingDataException;

    void delete(SuggestionAction suggestionAction) throws MissingDataException;

    SuggestionAction find(Long id) throws NotFoundException;
}
