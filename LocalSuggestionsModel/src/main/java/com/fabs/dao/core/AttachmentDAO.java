package com.fabs.dao.core;

import com.fabs.dao.BaseDAO;
import com.fabs.model.core.Attachment;
import com.fabs.model.exceptions.MissingDataException;

import java.util.Set;

public interface AttachmentDAO extends BaseDAO<Long, Attachment> {

    void saveOrUpdate(Set<Attachment> attachments) throws MissingDataException;

    void delete(Set<Attachment> attachments) throws MissingDataException;
}
