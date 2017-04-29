package com.fabs.dao;

import com.fabs.model.users.UserAccess;
import com.fabs.model.users.UserDecoration;
import com.fabs.model.users.UserDecorationPK;

public interface UserAccessDAO {
    void saveOrUpdate(UserAccess userDecoration);

    UserAccess find(Integer id);
}
