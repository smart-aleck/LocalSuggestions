package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.User;

import java.util.Set;

public interface UserDAO {

    void saveOrUpdate(User user) throws MissingDataException;

    void delete(User user) throws MissingDataException;

    User find(Integer id) throws NotFoundException;

    Set<User> find(Set<Integer> ids);
}
