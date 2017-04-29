package com.fabs.model.users;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class UserDecorationPK implements Serializable {
    private String userAccess;
    private String userDecorationName;

    @Column(name = "userAccess")
    @Id
    public String getUserAccess() {
        return userAccess;
    }

    public void setUserAccess(String userAccess) {
        this.userAccess = userAccess;
    }

    @Column(name = "userDecorationName")
    @Id
    public String getUserDecorationName() {
        return userDecorationName;
    }

    public void setUserDecorationName(String userDecorationName) {
        this.userDecorationName = userDecorationName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserDecorationPK that = (UserDecorationPK) o;

        if (userAccess != null ? !userAccess.equals(that.userAccess) : that.userAccess != null) return false;
        if (userDecorationName != null ? !userDecorationName.equals(that.userDecorationName) : that.userDecorationName != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userAccess != null ? userAccess.hashCode() : 0;
        result = 31 * result + (userDecorationName != null ? userDecorationName.hashCode() : 0);
        return result;
    }
}
