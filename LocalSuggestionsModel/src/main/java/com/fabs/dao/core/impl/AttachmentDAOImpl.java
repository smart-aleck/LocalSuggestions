package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.AttachmentDAO;
import com.fabs.model.core.Attachment;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public class AttachmentDAOImpl extends AbstractCoreDAO<Long, Attachment> implements AttachmentDAO {

    public void saveOrUpdate(Attachment attachment) throws MissingDataException {
        attachment.setVersion(attachment.getVersion() + 1);
        attachment.setUpdateTimestamp(null);
        saveOrUpdateEntity(attachment);
    }

    public void saveOrUpdate(Set<Attachment> attachments) throws MissingDataException {
        attachments.forEach(attachment -> {
            attachment.setVersion(attachment.getVersion() + 1);
            attachment.setUpdateTimestamp(null);
        });
        saveOrUpdateEntity(attachments);
    }

    public void delete(Attachment attachment) throws MissingDataException {
        attachment.setIsDeleted(true);
        saveOrUpdate(attachment);
    }

    public void delete(Set<Attachment> attachments) throws MissingDataException {
        attachments.forEach(attachment -> attachment.setIsDeleted(true));
        saveOrUpdate(attachments);
    }
}
