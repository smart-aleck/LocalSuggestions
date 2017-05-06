package com.fabs.dao.core;

import com.fabs.model.core.CommentLocation;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

public interface CommentLocationDAO {

    void saveOrUpdate(CommentLocation commentLocation) throws MissingDataException;

    void delete(CommentLocation commentLocation) throws MissingDataException;

    CommentLocation find(Integer id) throws NotFoundException;
}
