package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Decoration;

public interface DecorationDAO {

    void saveOrUpdate(Decoration decoration) throws MissingDataException;

    void delete(Decoration decoration) throws MissingDataException;

    Decoration find(Integer id) throws NotFoundException;
}
