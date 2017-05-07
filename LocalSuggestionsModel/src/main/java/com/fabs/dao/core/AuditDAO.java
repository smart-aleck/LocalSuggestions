package com.fabs.dao.core;

import com.fabs.model.core.Audit;
import com.fabs.model.exceptions.MissingDataException;

public interface AuditDAO {

    void log(Audit audit) throws MissingDataException;
}
