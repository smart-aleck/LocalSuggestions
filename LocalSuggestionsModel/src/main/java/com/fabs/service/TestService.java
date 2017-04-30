package com.fabs.service;

import com.fabs.dao.*;
import com.fabs.model.core.Audit;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.users.Decoration;
import com.fabs.model.users.User;
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

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserDecorationOverrideDAO userDecorationOverrideDAO;

    //@Transactional("transactionManager")
    public void runAuditTest(Audit audit){
        auditDAO.log(audit);
    }

    public Decoration runDecorationTest(Decoration decoration){
        decoration = decorationDAO.find(decoration.getId());
        decorationDAO.saveOrUpdate(decoration);
        return decoration;
    }

    public UserAccess runUserAccessTest(UserAccess userAccess){
        userAccess = userAccessDAO.find(userAccess.getId());
        userAccessDAO.saveOrUpdate(userAccess);
        return userAccess;
    }

    public User runUserTest(User user){
        user = userDAO.find(user.getId());
        userDAO.saveOrUpdate(user);
        return user;
    }

    public UserDecorationOverride runUserDecorationOverrideTest(UserDecorationOverride userDecorationOverride){
        userDecorationOverride = userDecorationOverrideDAO.find(userDecorationOverride.getId());
        userDecorationOverrideDAO.saveOrUpdate(userDecorationOverride);
        return userDecorationOverride;
    }
}
