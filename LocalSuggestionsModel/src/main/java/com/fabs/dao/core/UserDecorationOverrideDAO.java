package com.fabs.dao.core;

import com.fabs.dao.BaseDAO;
import com.fabs.model.core.UserDecorationOverride;

import java.util.Set;

public interface UserDecorationOverrideDAO extends BaseDAO<Integer, UserDecorationOverride> {

    Set<UserDecorationOverride> findByUser(Integer userId);
}
