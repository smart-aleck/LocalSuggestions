package com.fabs.dao.core;

import com.fabs.dao.BaseDAO;
import com.fabs.model.core.CommentAttachment;
import com.fabs.model.exceptions.MissingDataException;

import java.util.Set;

public interface CommentAttachmentDAO extends BaseDAO<Long, CommentAttachment> {

    void saveOrUpdate(Set<CommentAttachment> commentAttachments) throws MissingDataException;

    void delete(Set<CommentAttachment> commentAttachments) throws MissingDataException;
}
