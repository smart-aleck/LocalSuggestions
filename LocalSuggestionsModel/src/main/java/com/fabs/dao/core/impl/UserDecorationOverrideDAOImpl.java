package com.fabs.dao.core.impl;

import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashSet;
import java.util.Set;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class UserDecorationOverrideDAOImpl implements UserDecorationOverrideDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public UserDecorationOverrideDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(UserDecorationOverride userDecorationOverride) throws MissingDataException {
        try {
            userDecorationOverride.setVersion(userDecorationOverride.getVersion() + 1);
            userDecorationOverride.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(userDecorationOverride);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(userDecorationOverride, exception);
        }
    }

    public void delete(UserDecorationOverride userDecorationOverride) throws MissingDataException {
        userDecorationOverride.setDeleted(true);
        saveOrUpdate(userDecorationOverride);
    }

    public UserDecorationOverride find(Integer id) throws NotFoundException {
        UserDecorationOverride userDecorationOverride = sessionFactory.getCurrentSession().find(UserDecorationOverride.class, id);
        if(userDecorationOverride == null)
            throw new NotFoundException(String.format("[UserDecorationOverride] object with id {0} not found", id));

        return userDecorationOverride;
    }

    public Set<UserDecorationOverride> findByUser(Integer userId) {
        CriteriaBuilder builder = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<UserDecorationOverride> criteria = builder.createQuery(UserDecorationOverride.class);
        Root<UserDecorationOverride> root = criteria.from(UserDecorationOverride.class);
        criteria.select(root);
        criteria.where(builder.equal(root.get("userId"), userId));
        return new HashSet<>(
                sessionFactory.getCurrentSession().createQuery(criteria).getResultList());
    }
}
