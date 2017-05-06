package com.fabs.dao.core;

import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.users.User;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface UserDecorationOverrideDAO {

    void saveOrUpdate(UserDecorationOverride userDecorationOverride) throws MissingDataException;

    void delete(UserDecorationOverride userDecorationOverride) throws MissingDataException;

    UserDecorationOverride find(Integer id) throws NotFoundException;

    Set<UserDecorationOverride> findByUser(Integer userId);
}
