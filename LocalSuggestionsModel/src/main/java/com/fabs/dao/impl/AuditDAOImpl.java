package com.fabs.dao.impl;

import com.fabs.dao.AuditDAO;
import com.fabs.model.core.Audit;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AuditDAOImpl implements AuditDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void log(Audit audit) {
        sessionFactory.getCurrentSession().persist(audit);
    }
}
