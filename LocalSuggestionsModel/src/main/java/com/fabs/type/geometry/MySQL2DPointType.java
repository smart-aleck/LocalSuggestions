package com.fabs.type.geometry;

import org.hibernate.spatial.JTSGeometryType;
import org.hibernate.spatial.dialect.mysql.MySQLGeometryTypeDescriptor;

public class MySQL2DPointType extends JTSGeometryType {

    public MySQL2DPointType() {
        super(MySQLGeometryTypeDescriptor.INSTANCE);
    }
}
