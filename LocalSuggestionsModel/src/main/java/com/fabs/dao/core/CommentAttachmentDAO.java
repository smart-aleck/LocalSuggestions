package com.fabs.dao.core;

import com.fabs.model.core.CommentAttachment;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface CommentAttachmentDAO {

    void saveOrUpdate(CommentAttachment commentAttachment) throws MissingDataException;

    void saveOrUpdate(Set<CommentAttachment> commentAttachments) throws MissingDataException;

    void delete(CommentAttachment commentAttachment) throws MissingDataException;

    void delete(Set<CommentAttachment> commentAttachments) throws MissingDataException;

    CommentAttachment find(Long id) throws NotFoundException;
}
