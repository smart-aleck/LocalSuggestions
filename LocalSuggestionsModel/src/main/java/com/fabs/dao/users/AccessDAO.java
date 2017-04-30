package com.fabs.dao.users;

import com.fabs.model.users.Access;

public interface AccessDAO {
    void saveOrUpdate(Access access);

    Access find(Integer id);
}
