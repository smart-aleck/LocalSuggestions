package com.fabs.service;

import com.fabs.dao.core.AuditDAO;
import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.dao.users.DecorationDAO;
import com.fabs.dao.users.AccessDAO;
import com.fabs.dao.users.UserDAO;
import com.fabs.model.core.Audit;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
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
    AccessDAO accessDAO;

    @Autowired
    UserDAO userDAO;

    @Autowired
    UserDecorationOverrideDAO userDecorationOverrideDAO;

    //@Transactional("transactionManager")
    public void runAuditTest(Audit audit){
        auditDAO.log(audit);
    }

    public Decoration runDecorationTest(Decoration decoration) throws NotFoundException {
        decoration = decorationDAO.find(decoration.getId());
        //decorationDAO.saveOrUpdate(decoration);
        return decoration;
    }

    public Access runAccessTest(Access access) throws NotFoundException{
        access = accessDAO.find(access.getId());
        //userDAO.saveOrUpdate(access);
        return access;
    }

    public User runUserTest(User user) throws NotFoundException, MissingDataException {
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
