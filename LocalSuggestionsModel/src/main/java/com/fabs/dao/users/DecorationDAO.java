package com.fabs.dao.users;

import com.fabs.model.users.Decoration;

public interface DecorationDAO {
    void saveOrUpdate(Decoration decoration);

    Decoration find(Integer id);
}
