package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.AuditDAO;
import com.fabs.model.core.Audit;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class AuditDAOImpl extends AbstractCoreDAO<Long, Audit> implements AuditDAO {

    public void log(Audit audit) throws MissingDataException {
        saveOrUpdateEntity(audit);
    }
}
