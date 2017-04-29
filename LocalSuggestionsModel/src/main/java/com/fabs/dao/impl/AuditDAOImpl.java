package com.fabs.dao.impl;

import com.fabs.dao.AuditDAO;
import com.fabs.model.core.Audit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional("transactionManager")
public class AuditDAOImpl implements AuditDAO {

    @Autowired
    @Qualifier(value="sessionFactory")
    private SessionFactory sessionFactory;

    public void log(Audit audit) {
        sessionFactory.getCurrentSession().persist(audit);
    }
}
