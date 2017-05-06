package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Profile;

public interface ProfileDAO {

    void saveOrUpdate(Profile profile) throws MissingDataException;

    void delete(Profile profile) throws MissingDataException;

    Profile find(Integer id) throws NotFoundException;
}
