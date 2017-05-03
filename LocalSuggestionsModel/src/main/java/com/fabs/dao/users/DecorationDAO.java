package com.fabs.dao.users;

import com.fabs.model.users.Decoration;

public interface DecorationDAO {

    void saveOrUpdate(Decoration decoration);

    void delete(Integer id);

    Decoration find(Integer id);
}
