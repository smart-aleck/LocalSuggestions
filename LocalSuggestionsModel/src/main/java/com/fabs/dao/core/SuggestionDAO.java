package com.fabs.dao.core;

import com.fabs.dao.BaseDAO;
import com.fabs.model.core.Suggestion;
import com.vividsolutions.jts.geom.Point;
import com.fabs.model.exceptions.NotFoundException;

import java.util.Set;

public interface SuggestionDAO extends BaseDAO<Long, Suggestion> {

    Set<Suggestion> findByUser(Integer userId) throws NotFoundException;

    Set<Suggestion> find(Point location, Double radius);
}
