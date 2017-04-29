package com.fabs.dao;

import com.fabs.model.users.Decoration;

public interface DecorationDAO {
    void saveOrUpdate(Decoration userDecoration);

    Decoration find(Integer id);
}
