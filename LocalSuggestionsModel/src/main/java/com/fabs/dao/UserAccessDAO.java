package com.fabs.dao;

import com.fabs.model.users.UserAccess;

public interface UserAccessDAO {
    void saveOrUpdate(UserAccess userDecoration);

    UserAccess find(Integer id);
}
