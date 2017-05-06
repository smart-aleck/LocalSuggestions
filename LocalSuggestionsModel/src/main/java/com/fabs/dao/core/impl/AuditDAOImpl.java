package com.fabs.dao.core.impl;

import com.fabs.dao.core.AuditDAO;
import com.fabs.model.core.Audit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(value = "transactionManager", rollbackFor = Exception.class)
public class AuditDAOImpl implements AuditDAO {

    private SessionFactory sessionFactory;

    @Autowired
    public AuditDAOImpl(@Qualifier("sessionFactory") SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void log(Audit audit) {
        sessionFactory.getCurrentSession().persist(audit);
    }
}
