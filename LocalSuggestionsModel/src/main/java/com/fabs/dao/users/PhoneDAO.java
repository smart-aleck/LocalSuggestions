package com.fabs.dao.users;

import com.fabs.model.users.Phone;

public interface PhoneDAO {

    void saveOrUpdate(Phone phone);

    void delete(Integer id);

    Phone find(Integer id);
}
