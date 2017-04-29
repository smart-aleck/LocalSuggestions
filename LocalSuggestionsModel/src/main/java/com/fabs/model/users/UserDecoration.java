package com.fabs.model.users;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_decoration", schema = "local_suggestions_users")
@IdClass(UserDecorationPK.class)
public class UserDecoration {
    private String userAccess;
    private String userDecorationName;
    private Boolean defaultValue;
    private Integer version;
    private Timestamp updateTimestamp;
    private Byte isDeleted;

    @Id
    @Column(name = "userAccess")
    public String getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

    @Id
    @Column(name = "userDecorationName")
    public String getUserDecorationName() {
        return userDecorationName;
    }

    public void setUserDecorationName(String userDecorationName) {
        this.userDecorationName = userDecorationName;
    }

    @Basic
    @Column(name = "defaultValue")
    public Boolean getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Boolean defaultValue) {
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
    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDecoration that = (UserDecoration) o;

        if (userAccess != null ? !userAccess.equals(that.userAccess) : that.userAccess != null) return false;
        if (userDecorationName != null ? !userDecorationName.equals(that.userDecorationName) : that.userDecorationName != null)
            return false;
        if (defaultValue != null ? !defaultValue.equals(that.defaultValue) : that.defaultValue != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(that.updateTimestamp) : that.updateTimestamp != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userAccess != null ? userAccess.hashCode() : 0;
        result = 31 * result + (userDecorationName != null ? userDecorationName.hashCode() : 0);
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }
}
