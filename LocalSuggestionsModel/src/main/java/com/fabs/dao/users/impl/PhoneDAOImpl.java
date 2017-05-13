package com.fabs.dao.users.impl;

import com.fabs.dao.users.AbstractUsersDAO;
import com.fabs.dao.users.PhoneDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.users.Phone;
import org.springframework.stereotype.Repository;

@Repository
public class PhoneDAOImpl extends AbstractUsersDAO<Integer, Phone> implements PhoneDAO {

    public void saveOrUpdate(Phone phone) throws MissingDataException {
        phone.setVersion(phone.getVersion() + 1);
        phone.setUpdateTimestamp(null);
        saveOrUpdateEntity(phone);
    }

    public void delete(Phone phone) throws MissingDataException {
        phone.setIsDeleted(true);
        saveOrUpdate(phone);
    }
}
