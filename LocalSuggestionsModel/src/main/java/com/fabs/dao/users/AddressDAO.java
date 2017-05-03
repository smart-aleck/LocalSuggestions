package com.fabs.dao.users;

import com.fabs.model.users.Address;

public interface AddressDAO {

    void saveOrUpdate(Address address);

    void delete(Integer id);

    Address find(Integer id);
}
