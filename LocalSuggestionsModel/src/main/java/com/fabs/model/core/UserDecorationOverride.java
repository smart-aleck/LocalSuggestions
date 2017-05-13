package com.fabs.model.core;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_decoration_override")
public class UserDecorationOverride {
    private Integer id;
    private Integer userId;
    private String defaultValue;
    private Integer decorationId;
    private String decorationName;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "decorationId")
    public Integer getDecorationId() {
        return decorationId;
    }

    public void setDecorationId(Integer decorationId) {
        this.decorationId = decorationId;
    }

    @Basic
    @Column(name = "defaultValue")
    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    @Basic
    @Column(name = "updateTimestamp")
    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Basic
    @Column(name = "isDeleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "decorationName")
    public String getDecorationName() {
        return decorationName;
    }

    public void setDecorationName(String decorationName) {
        this.decorationName = decorationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDecorationOverride that = (UserDecorationOverride) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(that.updateTimestamp) : that.updateTimestamp != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (decorationId != null ? !decorationId.equals(that.decorationId) : that.decorationId != null) return false;
        if (decorationName != null ? !decorationName.equals(that.decorationName) : that.decorationName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (decorationId != null ? decorationId.hashCode() : 0);
        result = 31 * result + (decorationName != null ? decorationName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserDecorationOverride{" +
                "id=" + id +
                ", user=" + userId +
                ", defaultValue='" + defaultValue + '\'' +
                ", decoration=" + decorationId +
                ", decorationName='" + decorationName + '\'' +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
