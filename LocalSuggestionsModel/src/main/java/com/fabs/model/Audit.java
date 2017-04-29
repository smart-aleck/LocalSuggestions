package com.fabs.model;

import javax.persistence.*;
import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;

@Entity
@Table(name="audit")
public class Audit {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private int userId;
    @Column
    private String ip;
    @Column
    private String device;
    @Column
    private Timestamp timestamp;
    @Column
    @Type(type = "com.fabs.type.geometry.MySQL2DPointType")
    private Point location;
    @Column
    private String activity;
    @Column
    private String description;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "id=" + id +
                ", userId=" + userId +
                ", ip='" + ip + '\'' +
                ", device='" + device + '\'' +
                ", location=" + location +
                ", activity='" + activity + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
