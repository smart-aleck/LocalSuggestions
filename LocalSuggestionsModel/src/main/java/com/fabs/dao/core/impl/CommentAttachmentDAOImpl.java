package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.CommentAttachmentDAO;
import com.fabs.model.core.CommentAttachment;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class CommentAttachmentDAOImpl extends AbstractCoreDAO<Long, CommentAttachment> implements CommentAttachmentDAO {

    public void saveOrUpdate(CommentAttachment commentAttachment) throws MissingDataException {
        commentAttachment.setVersion(commentAttachment.getVersion() + 1);
        commentAttachment.setUpdateTimestamp(null);
        saveOrUpdateEntity(commentAttachment);
    }

    public void saveOrUpdate(Set<CommentAttachment> commentAttachments) throws MissingDataException {
        commentAttachments.forEach(commentAttachment -> {
            commentAttachment.setVersion(commentAttachment.getVersion() + 1);
            commentAttachment.setUpdateTimestamp(null);
        });
        saveOrUpdateEntity(commentAttachments);
    }

    public void delete(CommentAttachment commentAttachment) throws MissingDataException {
        commentAttachment.setIsDeleted(true);
        saveOrUpdateEntity(commentAttachment);
    }

    public void delete(Set<CommentAttachment> commentAttachments) throws MissingDataException {
        commentAttachments.forEach(commentAttachment -> commentAttachment.setIsDeleted(true));
        saveOrUpdateEntity(commentAttachments);
    }
}
