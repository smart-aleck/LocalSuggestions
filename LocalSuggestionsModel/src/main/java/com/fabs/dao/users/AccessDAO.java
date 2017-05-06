package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Access;

public interface AccessDAO {

    void saveOrUpdate(Access access) throws MissingDataException;

    void delete(Access access) throws MissingDataException;

    Access find(Integer id) throws NotFoundException;
}
