package com.fabs.service;

import com.fabs.dao.core.AuditDAO;
import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.dao.users.AccessDAO;
import com.fabs.dao.users.DecorationDAO;
import com.fabs.dao.users.UserDAO;
import com.fabs.model.core.Audit;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.Access;
import com.fabs.model.users.Decoration;
import com.fabs.model.users.User;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("daoService")
public class DAOService {

    @Autowired
    AccessDAO accessDAO;

    public Access find(Integer id){
        try {
            return accessDAO.find(id);
        }
        catch (NotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public void delete(Access access){
        try {
            accessDAO.delete(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    public Access add(Access access){
        try {
            accessDAO.saveOrUpdate(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
        return access;
    }

    public Access update(Access access){
        try {
            accessDAO.saveOrUpdate(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
        return access;
    }
}
