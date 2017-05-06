package com.fabs.dao.core.impl;

import com.fabs.dao.core.CommentAttachmentDAO;
import com.fabs.model.core.CommentAttachment;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.PersistenceException;
import java.util.Set;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class CommentAttachmentDAOImpl implements CommentAttachmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public CommentAttachmentDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(CommentAttachment commentAttachment) throws MissingDataException {
        try {
            commentAttachment.setVersion(commentAttachment.getVersion() + 1);
            commentAttachment.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(commentAttachment);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(commentAttachment, exception);
        }
    }

    public void saveOrUpdate(Set<CommentAttachment> commentAttachments) throws MissingDataException {
        try {
            for (CommentAttachment commentAttachment : commentAttachments) {
                commentAttachment.setVersion(commentAttachment.getVersion() + 1);
                commentAttachment.setUpdateTimestamp(null);
                sessionFactory.getCurrentSession().saveOrUpdate(commentAttachment);
            }
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(commentAttachments, exception);
        }
    }

    public void delete(CommentAttachment commentAttachment) throws MissingDataException {
        commentAttachment.setDeleted(true);
        saveOrUpdate(commentAttachment);
    }

    public void delete(Set<CommentAttachment> commentAttachments) throws MissingDataException {
        commentAttachments.forEach(commentAttachment -> commentAttachment.setDeleted(true));
        saveOrUpdate(commentAttachments);
    }

    public CommentAttachment find(Long id) throws NotFoundException {
        CommentAttachment commentAttachment = sessionFactory.getCurrentSession().find(CommentAttachment.class, id);
        if(commentAttachment == null)
            throw new NotFoundException(String.format("[CommentAttachment] object with id {0} not found", id));

        return commentAttachment;
    }
}
