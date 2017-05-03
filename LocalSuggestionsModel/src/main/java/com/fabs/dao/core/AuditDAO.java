package com.fabs.dao.core;

import com.fabs.model.core.Audit;

public interface AuditDAO {

    void log(Audit audit);
}
