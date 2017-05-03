package com.fabs.dao.core;

import com.fabs.model.core.Suggestion;
import com.fabs.model.users.User;
import com.vividsolutions.jts.geom.Point;

import java.util.Set;

public interface SuggestionDAO {

    void saveOrUpdate(Suggestion suggestion);

    void delete(Integer id);

    Suggestion find(Integer id);
    Set<Suggestion> find(User user);
    Set<Suggestion> find(Point location, Double radius);


}
