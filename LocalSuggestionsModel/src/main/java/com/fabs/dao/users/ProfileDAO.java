package com.fabs.dao.users;

import com.fabs.model.users.Profile;

public interface ProfileDAO {

    void saveOrUpdate(Profile profile);

    void delete(Integer id);

    Profile find(Integer id);
}
