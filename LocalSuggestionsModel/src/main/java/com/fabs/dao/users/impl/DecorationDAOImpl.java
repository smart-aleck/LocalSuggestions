package com.fabs.dao.users.impl;

import com.fabs.dao.users.AbstractUsersDAO;
import com.fabs.dao.users.DecorationDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.users.Decoration;
import org.springframework.stereotype.Repository;

@Repository
public class DecorationDAOImpl extends AbstractUsersDAO<Integer, Decoration> implements DecorationDAO {

    public void saveOrUpdate(Decoration decoration) throws MissingDataException {
        decoration.setVersion(decoration.getVersion() + 1);
        decoration.setUpdateTimestamp(null);
        saveOrUpdateEntity(decoration);
    }

    public void delete(Decoration decoration) throws MissingDataException {
        decoration.setIsDeleted(true);
        saveOrUpdate(decoration);
    }
}
