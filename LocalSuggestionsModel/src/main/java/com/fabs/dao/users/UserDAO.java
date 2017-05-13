package com.fabs.dao.users;

import com.fabs.dao.BaseDAO;
import com.fabs.model.users.User;

import java.util.Set;

public interface UserDAO extends BaseDAO<Integer, User> {

    Set<User> find(Set<Integer> ids);
}
