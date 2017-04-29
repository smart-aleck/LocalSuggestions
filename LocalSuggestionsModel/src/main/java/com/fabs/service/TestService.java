package com.fabs.service;

import com.fabs.dao.AuditDAO;
import com.fabs.model.Audit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testService")
public class TestService {

    @Autowired
    AuditDAO auditDAO;

    @Transactional
    public void runTest(Audit audit){
        auditDAO.log(audit);
    }

}
