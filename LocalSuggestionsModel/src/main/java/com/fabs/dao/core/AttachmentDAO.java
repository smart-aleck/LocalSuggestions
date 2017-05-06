package com.fabs.dao.core;

import com.fabs.model.core.Attachment;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface AttachmentDAO {

    void saveOrUpdate(Attachment attachment) throws MissingDataException;

    void saveOrUpdate(Set<Attachment> attachments) throws MissingDataException;

    void delete(Attachment attachment) throws MissingDataException;

    void delete(Set<Attachment> attachments) throws MissingDataException;

    Attachment find(Long id) throws NotFoundException;
}
