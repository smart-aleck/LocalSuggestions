package com.fabs.dao.users.impl;

import com.fabs.dao.users.AbstractUsersDAO;
import com.fabs.dao.users.ProfileDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.users.Profile;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDAOImpl extends AbstractUsersDAO<Integer, Profile> implements ProfileDAO {

    public void saveOrUpdate(Profile profile) throws MissingDataException {
        profile.setVersion(profile.getVersion() + 1);
        profile.setUpdateTimestamp(null);
        saveOrUpdateEntity(profile);
    }

    public void delete(Profile profile) throws MissingDataException {
        profile.setDeleted(true);
        saveOrUpdate(profile);
    }
}
