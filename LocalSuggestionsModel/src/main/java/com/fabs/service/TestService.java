package com.fabs.service;

import com.fabs.dao.AuditDAO;
import com.fabs.dao.DecorationDAO;
import com.fabs.dao.UserAccessDAO;
import com.fabs.model.core.Audit;
import com.fabs.model.users.Decoration;
import com.fabs.model.users.UserAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {

    @Autowired
    AuditDAO auditDAO;

    @Autowired
    DecorationDAO decorationDAO;

    @Autowired
    UserAccessDAO userAccessDAO;

    //@Transactional("transactionManager")
    public void runAuditTest(Audit audit){
        auditDAO.log(audit);
    }

//    //@Transactional("transactionManagerUsers")
    public void runDecorationTest(Decoration decoration){
        //decoration = decorationDAO.find(decoration.getId());
        decorationDAO.saveOrUpdate(decoration);
    }

    public UserAccess runUserAccessTest(UserAccess userAccess){
        userAccess = userAccessDAO.find(userAccess.getId());
        userAccessDAO.saveOrUpdate(userAccess);
        return userAccess;
    }
}
