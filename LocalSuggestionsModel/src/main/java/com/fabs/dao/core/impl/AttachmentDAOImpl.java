package com.fabs.dao.core.impl;

import com.fabs.dao.core.AttachmentDAO;
import com.fabs.model.core.Attachment;
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
public class AttachmentDAOImpl implements AttachmentDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AttachmentDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void saveOrUpdate(Attachment attachment) throws MissingDataException {
        try {
            attachment.setVersion(attachment.getVersion() + 1);
            attachment.setUpdateTimestamp(null);
            sessionFactory.getCurrentSession().saveOrUpdate(attachment);
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(attachment, exception);
        }
    }

    //http://websystique.com/springmvc/spring-mvc-4-fileupload-download-hibernate-example/
    public void saveOrUpdate(Set<Attachment> attachments) throws MissingDataException {
        try {
            for (Attachment attachment : attachments) {
                attachment.setVersion(attachment.getVersion() + 1);
                attachment.setUpdateTimestamp(null);
                sessionFactory.getCurrentSession().saveOrUpdate(attachment);
            }
            sessionFactory.getCurrentSession().flush();
        }
        catch(PersistenceException exception){
            throw new MissingDataException(attachments, exception);
        }
    }

    public void delete(Attachment attachment) throws MissingDataException {
        attachment.setDeleted(true);
        saveOrUpdate(attachment);
    }

    public void delete(Set<Attachment> attachments) throws MissingDataException {
        attachments.forEach(attachment -> attachment.setDeleted(true));
        saveOrUpdate(attachments);
    }

    public Attachment find(Long id) throws NotFoundException {
        Attachment attachment = sessionFactory.getCurrentSession().find(Attachment.class, id);
        if(attachment == null)
            throw new NotFoundException(String.format("[Attachment] object with id {0} not found", id));

        return attachment;
    }
}
