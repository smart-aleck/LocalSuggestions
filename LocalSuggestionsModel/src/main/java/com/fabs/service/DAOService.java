package com.fabs.service;

import com.fabs.dao.users.UserDAO;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Service("daoService")
public class DAOService {

    @Autowired
    UserDAO userDAO;

    public User find(Integer id){
        try {
            Set<Integer> ids = new HashSet<Integer>(Arrays.asList(1,2,3,7));
            Set<User> users = userDAO.find(ids);

            User user = userDAO.find(id);
            return user;
        }
        catch (NotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public void delete(User access){
        try {
            userDAO.delete(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    public User add(User access){
        try {
            userDAO.saveOrUpdate(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
        return access;
    }

    public User update(User access){
        try {
            userDAO.saveOrUpdate(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
        return access;
    }
}
