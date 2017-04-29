package com.fabs.dao;

import com.fabs.model.core.Audit;

public interface AuditDAO {
    void log(Audit audit);
}
