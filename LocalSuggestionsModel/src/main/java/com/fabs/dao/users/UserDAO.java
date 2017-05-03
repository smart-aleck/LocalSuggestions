package com.fabs.dao.users;

import com.fabs.model.users.User;

import java.util.Set;

public interface UserDAO {

    void saveOrUpdate(User user);

    void delete(Integer id);

    User find(Integer id);

    Set<User> find(Set<Integer> ids);
}
