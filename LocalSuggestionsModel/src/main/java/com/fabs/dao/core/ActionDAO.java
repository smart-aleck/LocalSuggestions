package com.fabs.dao.core;

import com.fabs.model.core.Action;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

public interface ActionDAO {

    void saveOrUpdate(Action action) throws MissingDataException;

    void delete(Action action) throws MissingDataException;

    Action find(Integer id) throws NotFoundException;
}
