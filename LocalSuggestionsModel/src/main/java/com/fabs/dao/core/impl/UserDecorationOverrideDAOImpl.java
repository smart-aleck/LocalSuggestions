package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class UserDecorationOverrideDAOImpl extends AbstractCoreDAO<Integer, UserDecorationOverride> implements UserDecorationOverrideDAO {

    public void saveOrUpdate(UserDecorationOverride userDecorationOverride) throws MissingDataException {
        userDecorationOverride.setVersion(userDecorationOverride.getVersion() + 1);
        userDecorationOverride.setUpdateTimestamp(null);
        saveOrUpdateEntity(userDecorationOverride);
    }

    public void delete(UserDecorationOverride userDecorationOverride) throws MissingDataException {
        userDecorationOverride.setDeleted(true);
        saveOrUpdate(userDecorationOverride);
    }

    public Set<UserDecorationOverride> findByUser(Integer userId) {
        return findByFieldEquals("userId", userId);
    }
}
