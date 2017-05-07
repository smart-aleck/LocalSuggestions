package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.SuggestionDAO;
import com.fabs.model.core.Suggestion;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;
import com.vividsolutions.jts.geom.Point;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Repository
public class SuggestionDAOImpl extends AbstractCoreDAO<Long, Suggestion> implements SuggestionDAO {

    public void saveOrUpdate(Suggestion suggestion) throws MissingDataException {
        suggestion.setVersion(suggestion.getVersion() + 1);
        suggestion.setUpdateTimestamp(null);
        saveOrUpdateEntity(suggestion);
    }

    public void delete(Suggestion suggestion) throws MissingDataException {
        saveOrUpdate(suggestion);
        suggestion.setDeleted(true);
    }

    public Set<Suggestion> findByUser(Integer userId) throws NotFoundException {
        return findByFieldEquals("userId", userId);
    }

    // http://stackoverflow.com/questions/1006654/fastest-way-to-find-distance-between-two-lat-long-points
    public Set<Suggestion> find(Point location, Double radius) {
        String queryStr =
            "   SELECT * FROM local_suggestions.suggestion " +
            "   WHERE MBRContains (" +
            "       LineString (" +
            "           Point (:lon + :radius / ( :units / COS(RADIANS(:lat))), :lat + :radius / :units )," +
            "           Point (:lon - :radius / ( :units / COS(RADIANS(:lat))), :lat - :radius / :units ) ), " +
            "       location )";

        Map<String, Object> namedParameters = new HashMap<>();
        namedParameters.put("lon", location.getX());
        namedParameters.put("lat", location.getY());
        namedParameters.put("radius", radius);
        namedParameters.put("units", 111.1); // KM

        return findByQuery(queryStr, namedParameters);
    }
}
