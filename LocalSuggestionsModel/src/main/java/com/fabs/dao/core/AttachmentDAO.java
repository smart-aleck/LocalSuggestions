package com.fabs.dao.core;

import com.fabs.model.core.Attachment;

import java.util.Set;

public interface AttachmentDAO {

    void saveOrUpdate(Attachment attachment);

    void saveOrUpdate(Set<Attachment> attachments);

    void delete(Integer id);

    Attachment find(Integer id);
}
