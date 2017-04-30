package com.fabs.service;

import com.fabs.dao.core.AuditDAO;
import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.dao.users.DecorationDAO;
import com.fabs.dao.users.UserAccessDAO;
import com.fabs.dao.users.UserDAO;
import com.fabs.model.core.Audit;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.users.Access;
import com.fabs.model.users.Decoration;
import com.fabs.model.users.User;
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

    public Access runUserAccessTest(Access access){
        access = userAccessDAO.find(access.getId());
        userAccessDAO.saveOrUpdate(access);
        return access;
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
