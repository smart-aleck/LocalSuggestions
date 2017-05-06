package com.fabs.service;

import com.fabs.dao.core.SuggestionTagDAO;
import com.fabs.model.core.SuggestionTag;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("daoService")
public class DAOService {

    @Autowired
    SuggestionTagDAO suggestionTagDAO;

    public SuggestionTag find(Integer id){
        try {
            SuggestionTag suggestionTag = suggestionTagDAO.find(Integer.toUnsignedLong(id));
            return suggestionTag;
        }
        catch (NotFoundException e){
            e.printStackTrace();
            return null;
        }
    }

    public void delete(SuggestionTag access){
        try {
            suggestionTagDAO.delete(access);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
    }

    public SuggestionTag update(SuggestionTag access){
        try {
            Set<SuggestionTag> set = new HashSet<>();
            set.add(access);
            set.add(find(2));

            suggestionTagDAO.saveOrUpdate(set);
        } catch (MissingDataException e) {
            e.printStackTrace();
        }
        return access;
    }
}
