package com.fabs.model.users;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "access")
public class Access {
    private Integer id;
    private String accessText;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;
    private Set<Decoration> decorations;
    private Set<User> users;

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
    @Column(name = "accessText")
    public String getAccessText() {
        return accessText;
    }

    public void setAccessText(String accessText) {
        this.accessText = accessText;
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
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "access")
    public Set<Decoration> getDecorations() {
        return this.decorations;
    }

    public void setDecorations(Set<Decoration> decorations) {
        this.decorations = decorations;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "access")
    public Set<User> getUsers() {
        return this.users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Access that = (Access) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (accessText != null ? !accessText.equals(that.accessText) : that.accessText != null)
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
        result = 31 * result + (accessText != null ? accessText.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Access{" +
                "id=" + id +
                ", accessText='" + accessText + '\'' +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
