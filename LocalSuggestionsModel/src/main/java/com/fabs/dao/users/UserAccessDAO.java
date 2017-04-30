package com.fabs.dao.users;

import com.fabs.model.users.UserAccess;

public interface UserAccessDAO {
    void saveOrUpdate(UserAccess userAccess);

    UserAccess find(Integer id);
}
