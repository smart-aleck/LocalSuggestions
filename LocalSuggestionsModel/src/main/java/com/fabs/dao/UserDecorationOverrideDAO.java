package com.fabs.dao;

import com.fabs.model.core.UserDecorationOverride;

public interface UserDecorationOverrideDAO {
    void saveOrUpdate(UserDecorationOverride userDecorationOverride);

    UserDecorationOverride find(Integer id);
}
