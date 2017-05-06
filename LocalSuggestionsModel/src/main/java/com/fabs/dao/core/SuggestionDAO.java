package com.fabs.dao.core;

import com.fabs.model.core.Suggestion;
import com.fabs.model.users.User;
import com.vividsolutions.jts.geom.Point;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface SuggestionDAO {

    void saveOrUpdate(Suggestion suggestion) throws MissingDataException;

    void delete(Suggestion suggestion) throws MissingDataException;

    Suggestion find(Long id) throws NotFoundException;
    Set<Suggestion> findByUser(Integer userId) throws NotFoundException;
    Set<Suggestion> find(Point location, Double radius);
}
