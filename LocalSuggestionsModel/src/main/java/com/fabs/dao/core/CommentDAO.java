package com.fabs.dao.core;

import com.fabs.model.core.Comment;
import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

public interface CommentDAO {

    void saveOrUpdate(Comment comment) throws MissingDataException;

    void delete(Comment comment) throws MissingDataException;

    Comment find(Long id) throws NotFoundException;
}
