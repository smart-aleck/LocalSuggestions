package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.ActionDAO;
import com.fabs.model.core.Action;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

@Repository
public class ActionDAOImpl extends AbstractCoreDAO<Integer, Action> implements ActionDAO {

    public void saveOrUpdate(Action action) throws MissingDataException {
        action.setVersion(action.getVersion() + 1);
        action.setUpdateTimestamp(null);
        saveOrUpdateEntity(action);
    }

    public void delete(Action action) throws MissingDataException {
        action.setIsDeleted(true);
        saveOrUpdate(action);
    }
}
