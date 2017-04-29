package com.fabs.dao;

import com.fabs.model.Audit;

public interface AuditDAO {
    void log(Audit audit);
}
