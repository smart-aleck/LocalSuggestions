package com.fabs.service;

import com.fabs.dao.core.ActionDAO;
import com.fabs.dao.core.SuggestionDAO;
import com.fabs.dao.core.UserDecorationOverrideDAO;
import com.fabs.dao.users.UserDAO;
import com.fabs.model.core.Action;
import com.fabs.model.core.Suggestion;
import com.fabs.model.core.UserDecorationOverride;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.fabs.model.users.User;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("daoService")
public class DAOService {

    @Autowired
    SuggestionDAO suggestionDAO;

    @Autowired
    UserDAO userDAO;

    public User find(Integer id){
        try {
            GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910);
            Point p = geometryFactory.createPoint(new Coordinate(-0.1620211, 51.4346670));

            Set<Suggestion> suggestions = suggestionDAO.find(p,10.0);
            suggestions = suggestionDAO.findByUser(1);
            Suggestion suggestion = suggestionDAO.find(1L);
            User user = userDAO.find(1);

//            UserDecorationOverride action = dao.find(id);
//            Set<UserDecorationOverride> actionSet = dao.findByUser(id);
            //dao.delete(action);
//            Action action = new Action();
//            action.setActionText("OLA");
//            dao.saveOrUpdate(action);
            return null;
        }
//        catch (MissingDataException e){
//            e.printStackTrace();
//            return null;
//        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

//    public void delete(Suggestion access){
//        try {
//            SuggestionDAO.delete(access);
//        } catch (MissingDataException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public Suggestion update(Suggestion access){
//        try {
//            Set<Suggestion> set = new HashSet<>();
//            set.add(access);
//            set.add(find(2));
//
//            SuggestionDAO.saveOrUpdate(set);
//        } catch (MissingDataException e) {
//            e.printStackTrace();
//        }
//        return access;
//    }
}
