package com.fabs.dao.core;

import com.fabs.model.core.Comment;

public interface CommentDAO {

    void saveOrUpdate(Comment comment);

    void delete(Integer id);

    Comment find(Integer id);
}
