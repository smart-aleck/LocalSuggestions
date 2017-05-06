package com.fabs.dao.core;

import com.fabs.model.core.CommentLocation;

import java.util.Set;

public interface CommentLocationDAO {

    void saveOrUpdate(CommentLocation commentLocation);

    void saveOrUpdate(Set<CommentLocation> commentLocations);

    void delete(Integer id);

    CommentLocation find(Integer id);
}
