package com.fabs.model.users;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "user_access", schema = "local_suggestions_users")
public class UserAccess {
    private Integer id;
    private String userAccessText;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;

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
    @Column(name = "userAccessText")
    public String getUserAccessText() {
        return userAccessText;
    }

    public void setUserAccessText(String userAccessText) {
        this.userAccessText = userAccessText;
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

    public void setUpdateTimestamp(Timestamp updatedTimestamp) {
        this.updateTimestamp = updatedTimestamp;
    }

    @Basic
    @Column(name = "isDeleted")
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserAccess that = (UserAccess) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userAccessText != null ? !userAccessText.equals(that.userAccessText) : that.userAccessText != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(that.updateTimestamp) : that.updateTimestamp != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userAccessText != null ? userAccessText.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserAccess{" +
                "id=" + id +
                ", userAccessText='" + userAccessText + '\'' +
                ", version=" + version +
                ", updatedTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
