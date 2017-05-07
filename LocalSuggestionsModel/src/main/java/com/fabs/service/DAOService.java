package com.fabs.service;

import com.fabs.dao.core.ActionDAO;
import com.fabs.dao.core.SuggestionDAO;
import com.fabs.model.core.Action;
import com.fabs.model.core.Suggestion;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("daoService")
public class DAOService {

    @Autowired
    ActionDAO actionDAO;

    public Action find(Integer id){
        try {
//            GeometryFactory geometryFactory = new GeometryFactory(new PrecisionModel(), 26910);
//            Point p = geometryFactory.createPoint(new Coordinate(-0.1620211, 51.4346670));

//            Set<Suggestion> suggestions = SuggestionDAO.find(p,10.0);

            Action action = actionDAO.find(id);
            //actionDAO.delete(action);
//            Action action = new Action();
//            action.setActionText("OLA");
//            actionDAO.saveOrUpdate(action);
            return action;
        }
//        catch (MissingDataException e){
//            e.printStackTrace();
//            return null;
//        }
        catch (NotFoundException e){
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
