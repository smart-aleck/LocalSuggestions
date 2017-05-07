package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.CommentDAO;
import com.fabs.model.core.Comment;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

@Repository
public class CommentDAOImpl extends AbstractCoreDAO<Long, Comment> implements CommentDAO {

    public void saveOrUpdate(Comment comment) throws MissingDataException {
        comment.setVersion(comment.getVersion() + 1);
        comment.setUpdateTimestamp(null);
        saveOrUpdateEntity(comment);
    }

    public void delete(Comment comment) throws MissingDataException {
        saveOrUpdate(comment);
        comment.setDeleted(true);
    }
}
