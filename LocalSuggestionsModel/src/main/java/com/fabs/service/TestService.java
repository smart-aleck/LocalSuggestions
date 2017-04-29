package com.fabs.service;

import com.fabs.dao.AuditDAO;
import com.fabs.dao.UserAccessDAO;
import com.fabs.dao.UserDecorationDAO;
import com.fabs.model.core.Audit;
import com.fabs.model.users.UserAccess;
import com.fabs.model.users.UserDecoration;
import com.fabs.model.users.UserDecorationPK;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("testService")
public class TestService {

    @Autowired
    AuditDAO auditDAO;

    @Autowired
    UserDecorationDAO userDecorationDAO;

    @Autowired
    UserAccessDAO userAccessDAO;

    //@Transactional("transactionManager")
    public void runTest(Audit audit){
        auditDAO.log(audit);
    }

    //@Transactional("transactionManagerUsers")
    public void runUsersTest(UserDecoration userDecoration){
        userDecoration = userDecorationDAO.find(new UserDecorationPK(userDecoration));
        userDecorationDAO.saveOrUpdate(userDecoration);
    }

    public void runUserAccessTest(UserAccess userAccess){
        userAccess = userAccessDAO.find(userAccess.getId());
        userAccessDAO.saveOrUpdate(userAccess);
    }
}
