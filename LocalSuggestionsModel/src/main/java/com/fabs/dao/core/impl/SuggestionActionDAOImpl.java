package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.SuggestionActionDAO;
import com.fabs.model.core.SuggestionAction;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

@Repository
public class SuggestionActionDAOImpl extends AbstractCoreDAO<Long, SuggestionAction> implements SuggestionActionDAO {

    public void saveOrUpdate(SuggestionAction suggestionAction) throws MissingDataException {
        suggestionAction.setVersion(suggestionAction.getVersion() + 1);
        suggestionAction.setUpdateTimestamp(null);
        saveOrUpdateEntity(suggestionAction);
    }

    public void delete(SuggestionAction suggestionAction) throws MissingDataException {
        suggestionAction.setDeleted(true);
        saveOrUpdate(suggestionAction);
    }
}
