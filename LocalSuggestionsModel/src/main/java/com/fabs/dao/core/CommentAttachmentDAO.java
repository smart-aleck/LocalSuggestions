package com.fabs.dao.core;

import com.fabs.model.core.CommentAttachment;

import java.util.Set;

public interface CommentAttachmentDAO {

    void saveOrUpdate(CommentAttachment commentAttachment);

    void saveOrUpdate(Set<CommentAttachment> commentAttachments);

    void delete(Integer id);

    CommentAttachment find(Integer id);
}
