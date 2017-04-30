package com.fabs.dao.core;

import com.fabs.model.core.UserDecorationOverride;

public interface UserDecorationOverrideDAO {
    void saveOrUpdate(UserDecorationOverride userDecorationOverride);

    UserDecorationOverride find(Integer id);
}
