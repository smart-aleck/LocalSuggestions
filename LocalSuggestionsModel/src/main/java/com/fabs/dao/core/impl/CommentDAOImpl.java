package com.fabs.dao.core.impl;

import com.fabs.dao.core.CommentDAO;
import com.fabs.model.core.Comment;
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
public class CommentDAOImpl implements CommentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CommentDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Comment comment) throws MissingDataException {
        try {
            comment.setVersion(comment.getVersion() + 1);
            comment.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(comment);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(comment, exception);
        }
    }

    public void delete(Comment comment) throws MissingDataException {
        saveOrUpdate(comment);
        comment.setDeleted(true);
    }

    public Comment find(Long id) throws NotFoundException {
        Comment comment = sessionFactory.getCurrentSession().find(Comment.class, id);
        if(comment == null)
            throw new NotFoundException(String.format("[Comment] object with id {0} not found", id));

        return comment;
    }
}
