package com.fabs.dao.core.impl;

import com.fabs.dao.core.AbstractCoreDAO;
import com.fabs.dao.core.CommentLocationDAO;
import com.fabs.model.core.CommentLocation;
import com.fabs.model.exceptions.MissingDataException;
import org.springframework.stereotype.Repository;

@Repository
public class CommentLocationDAOImpl extends AbstractCoreDAO<Integer, CommentLocation> implements CommentLocationDAO {

    public void saveOrUpdate(CommentLocation commentLocation) throws MissingDataException {
        commentLocation.setVersion(commentLocation.getVersion() + 1);
        commentLocation.setUpdateTimestamp(null);
        saveOrUpdateEntity(commentLocation);
    }

    public void delete(CommentLocation commentLocation) throws MissingDataException {
        commentLocation.setDeleted(true);
        saveOrUpdate(commentLocation);
    }
}
