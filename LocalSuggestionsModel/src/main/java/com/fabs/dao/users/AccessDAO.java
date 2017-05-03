package com.fabs.dao.users;

import com.fabs.model.users.Access;

public interface AccessDAO {

    void saveOrUpdate(Access access);

    void delete(Integer id);

    Access find(Integer id);
}
