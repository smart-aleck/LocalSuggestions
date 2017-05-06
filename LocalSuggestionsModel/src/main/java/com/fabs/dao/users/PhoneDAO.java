package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Phone;

public interface PhoneDAO {

    void saveOrUpdate(Phone phone) throws MissingDataException;

    void delete(Phone phone) throws MissingDataException;

    Phone find(Integer id) throws NotFoundException;
}
