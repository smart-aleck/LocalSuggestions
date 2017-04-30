package com.fabs.dao.users;

import com.fabs.model.users.Access;

public interface UserAccessDAO {
    void saveOrUpdate(Access access);

    Access find(Integer id);
}
