package com.fabs.dao.users.impl;

import com.fabs.dao.users.AbstractUsersDAO;
import com.fabs.dao.users.AccessDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.users.Access;
import org.springframework.stereotype.Repository;

@Repository
public class AccessDAOImpl extends AbstractUsersDAO<Integer, Access> implements AccessDAO {

    public void saveOrUpdate(Access access) throws MissingDataException {
        access.setVersion(access.getVersion() + 1);
        access.setUpdateTimestamp(null);
        saveOrUpdateEntity(access);
    }

    public void delete(Access access) throws MissingDataException {
        access.setIsDeleted(true);
        saveOrUpdate(access);
    }
}
