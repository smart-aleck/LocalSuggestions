package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.SuggestionTagDAO;
import com.fabs.model.core.Attachment;
import com.fabs.model.core.SuggestionTag;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Set;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class SuggestionTagDAOImpl extends AbstractCoreDAO<Long, SuggestionTag> implements SuggestionTagDAO {

    public void saveOrUpdate(SuggestionTag suggestionTag) throws MissingDataException {
        suggestionTag.setVersion(suggestionTag.getVersion() + 1);
        suggestionTag.setUpdateTimestamp(null);
        saveOrUpdateEntity(suggestionTag);
    }

    public void saveOrUpdate(Set<SuggestionTag> suggestionTags) throws MissingDataException {
        suggestionTags.forEach(suggestionTag -> {
            suggestionTag.setVersion(suggestionTag.getVersion() + 1);
            suggestionTag.setUpdateTimestamp(null);
        });
        saveOrUpdateEntity(suggestionTags);
    }

    public void delete(SuggestionTag suggestionTag) throws MissingDataException {
        suggestionTag.setDeleted(true);
        saveOrUpdate(suggestionTag);
    }

    public void delete(Set<SuggestionTag> suggestionTags) throws MissingDataException {
        suggestionTags.forEach(suggestionTag -> suggestionTag.setDeleted(true));
        saveOrUpdate(suggestionTags);
    }
}
