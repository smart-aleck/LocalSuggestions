package com.fabs.dao.users.impl;

import com.fabs.dao.users.AbstractUsersDAO;
import com.fabs.dao.users.AddressDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.users.Address;
import org.springframework.stereotype.Repository;

@Repository
public class AddressDAOImpl extends AbstractUsersDAO<Integer, Address> implements AddressDAO {

    public void saveOrUpdate(Address address) throws MissingDataException {
        address.setVersion(address.getVersion() + 1);
        address.setUpdateTimestamp(null);
        saveOrUpdateEntity(address);
    }

    public void delete(Address address) throws MissingDataException {
        address.setDeleted(true);
        saveOrUpdate(address);
    }
}
