package com.fabs.dao;

import com.fabs.model.exceptions.MissingDataException;
import com.fabs.model.exceptions.NotFoundException;

import java.io.Serializable;

public interface BaseDAO<PK extends Serializable, T> {

    T refresh(T entity);

    void saveOrUpdate(T entity) throws MissingDataException;

    void delete(T entity) throws MissingDataException;

    T find(PK id) throws NotFoundException;

    Long count();
    Long count(Boolean withDeleted);
}
