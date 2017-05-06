package com.fabs.dao.users.impl;

import com.fabs.dao.users.ProfileDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Profile;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "transactionManagerUsers", rollbackFor = Exception.class)
public class ProfileDAOImpl implements ProfileDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public ProfileDAOImpl(@Qualifier("sessionFactoryUsers") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Profile profile) throws MissingDataException {
        try {
            profile.setVersion(profile.getVersion() + 1);
            profile.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(profile);
        }
        catch(ConstraintViolationException exception){
            throw new MissingDataException(profile, exception);
        }
    }

    public void delete(Profile profile) throws MissingDataException {
        try {
            profile.setDeleted(true);
            saveOrUpdate(profile);
        }
        catch(ConstraintViolationException exception){
            throw new MissingDataException(profile, exception);
        }
    }

    public Profile find(Integer id) throws NotFoundException {
        Profile profile = sessionFactory.getCurrentSession().find(Profile.class, id);
        if(profile == null)
            throw new NotFoundException(String.format("[Profile] object with id {0} not found", id));

        return profile;
    }
}
