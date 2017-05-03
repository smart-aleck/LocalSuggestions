package com.fabs.dao.core;

import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.users.User;

import java.util.Set;

public interface UserDecorationOverrideDAO {

    void saveOrUpdate(UserDecorationOverride userDecorationOverride);

    void delete(Integer id);

    UserDecorationOverride find(Integer id);

    Set<UserDecorationOverride> find(User user);
}
