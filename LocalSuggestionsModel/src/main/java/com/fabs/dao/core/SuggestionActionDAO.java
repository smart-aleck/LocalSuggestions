package com.fabs.dao.core;

import com.fabs.model.core.SuggestionAction;

public interface SuggestionActionDAO {

    void saveOrUpdate(SuggestionAction suggestionAction);

    void delete(Integer id);

    SuggestionAction find(Integer id);
}
