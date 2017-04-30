package com.fabs.model.core;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "action", schema = "local_suggestions")
public class Action {
    private Integer id;
    private String actionText;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;

    @Basic
    @Column(name = "version")
    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
    @Column(name = "actionText")
    public String getActionText() {
        return actionText;
    }

    public void setActionText(String actionText) {
        this.actionText = actionText;
    }

    @Basic
    @Column(name = "updateTimestamp")
    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Action action = (Action) o;

        if (version != null ? !version.equals(action.version) : action.version != null) return false;
        if (isDeleted != null ? !isDeleted.equals(action.isDeleted) : action.isDeleted != null) return false;
        if (id != null ? !id.equals(action.id) : action.id != null) return false;
        if (actionText != null ? !actionText.equals(action.actionText) : action.actionText != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(action.updateTimestamp) : action.updateTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = version != null ? version.hashCode() : 0;
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (actionText != null ? actionText.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Action{" +
                "id=" + id +
                ", actionText='" + actionText + '\'' +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
