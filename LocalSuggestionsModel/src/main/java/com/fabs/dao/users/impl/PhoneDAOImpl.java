package com.fabs.dao.users.impl;

import com.fabs.dao.users.PhoneDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Phone;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Repository
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public class PhoneDAOImpl implements PhoneDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public PhoneDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Phone phone) throws MissingDataException {
        try {
            phone.setVersion(phone.getVersion() + 1);
            phone.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(phone);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(phone, exception);
        }
    }

    public void delete(Phone phone) throws MissingDataException {
        phone.setDeleted(true);
        saveOrUpdate(phone);
    }

    public Phone find(Integer id) throws NotFoundException {
        Phone phone = sessionFactory.getCurrentSession().find(Phone.class, id);
        if(phone == null)
            throw new NotFoundException(String.format("[Phone] object with id {0} not found", id));

        return phone;
    }
}
