package com.fabs.dao.users.impl;

import com.fabs.dao.users.AbstractUsersDAO;
import com.fabs.dao.users.UserDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.users.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl extends AbstractUsersDAO<Integer, User> implements UserDAO {

    public void saveOrUpdate(User user) throws MissingDataException {
        user.setVersion(user.getVersion() + 1);
        user.setUpdateTimestamp(null);
        saveOrUpdateEntity(user);
    }

    public void delete(User user) throws MissingDataException {
        user.setIsDeleted(true);
        saveOrUpdate(user);
    }
}
