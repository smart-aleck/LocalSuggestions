package com.fabs.dao.core.impl;

import com.fabs.dao.core.CommentLocationDAO;
import com.fabs.model.core.CommentLocation;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class CommentLocationDAOImpl implements CommentLocationDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CommentLocationDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(CommentLocation commentLocation) throws MissingDataException {
        try {
            commentLocation.setVersion(commentLocation.getVersion() + 1);
            commentLocation.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(commentLocation);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(commentLocation, exception);
        }
    }

    public void delete(CommentLocation commentLocation) throws MissingDataException {
        commentLocation.setDeleted(true);
        saveOrUpdate(commentLocation);
    }

    public CommentLocation find(Integer id) throws NotFoundException {
        CommentLocation commentLocation = sessionFactory.getCurrentSession().find(CommentLocation.class, id);
        if(commentLocation == null)
            throw new NotFoundException(String.format("[CommentLocation] object with id {0} not found", id));

        return commentLocation;
    }
}
