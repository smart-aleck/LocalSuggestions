package com.fabs.dao.users;

import com.fabs.model.users.User;

public interface UserDAO {
    void saveOrUpdate(User user);

    User find(Integer id);
}
