package com.fabs.dao.users.impl;

import com.fabs.dao.users.AddressDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Address;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Repository
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public class AddressDAOImpl implements AddressDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AddressDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Address address) throws MissingDataException {
        try {
            address.setVersion(address.getVersion() + 1);
            address.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(address);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(address, exception);
        }
    }

    public void delete(Address address) throws MissingDataException {
        address.setDeleted(true);
        saveOrUpdate(address);
    }

    public Address find(Integer id) throws NotFoundException {
        Address address = sessionFactory.getCurrentSession().find(Address.class, id);
        if(address == null)
            throw new NotFoundException(String.format("[Address] object with id {0} not found", id));

        return address;
    }
}
