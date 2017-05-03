package com.fabs.dao.core;

import com.fabs.model.core.Action;

public interface ActionDAO {

    void saveOrUpdate(Action action);

    void delete(Integer id);

    Action find(Integer id);
}
