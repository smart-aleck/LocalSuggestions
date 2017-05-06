package com.fabs.dao.users;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Address;

public interface AddressDAO {

    void saveOrUpdate(Address address) throws MissingDataException;

    void delete(Address address) throws MissingDataException;

    Address find(Integer id) throws NotFoundException;
}
