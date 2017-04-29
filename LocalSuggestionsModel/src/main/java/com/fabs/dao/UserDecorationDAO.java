package com.fabs.dao;

import com.fabs.model.users.UserDecoration;
import com.fabs.model.users.UserDecorationPK;

public interface UserDecorationDAO {
    void saveOrUpdate(UserDecoration userDecoration);

    UserDecoration find(UserDecorationPK userDecorationPK);
}
