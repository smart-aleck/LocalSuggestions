package com.fabs.model.users;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Table(name = "user", schema = "local_suggestions_users")
public class User {
    private Integer userId;
    private String displayName;
    private String firstName;
    private String lastName;
    private String email;
    private String passwordSalt;
    private String passwordHash;
    private Date dateJoined;
    private Integer version;
    private Timestamp updatedTimestamp;
    private Boolean isDeleted;

    @Id
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "displayName")
    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "passwordSalt")
    public String getPasswordSalt() {
        return passwordSalt;
    }

    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    @Basic
    @Column(name = "passwordHash")
    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    @Basic
    @Column(name = "dateJoined")
    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
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
    @Column(name = "updatedTimestamp")
    public Timestamp getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    public void setUpdatedTimestamp(Timestamp updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
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

        User user = (User) o;

        if (userId != null ? !userId.equals(user.userId) : user.userId != null) return false;
        if (displayName != null ? !displayName.equals(user.displayName) : user.displayName != null) return false;
        if (firstName != null ? !firstName.equals(user.firstName) : user.firstName != null) return false;
        if (lastName != null ? !lastName.equals(user.lastName) : user.lastName != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (passwordSalt != null ? !passwordSalt.equals(user.passwordSalt) : user.passwordSalt != null) return false;
        if (passwordHash != null ? !passwordHash.equals(user.passwordHash) : user.passwordHash != null) return false;
        if (dateJoined != null ? !dateJoined.equals(user.dateJoined) : user.dateJoined != null) return false;
        if (version != null ? !version.equals(user.version) : user.version != null) return false;
        if (updatedTimestamp != null ? !updatedTimestamp.equals(user.updatedTimestamp) : user.updatedTimestamp != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(user.isDeleted) : user.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (displayName != null ? displayName.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (passwordSalt != null ? passwordSalt.hashCode() : 0);
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        result = 31 * result + (dateJoined != null ? dateJoined.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updatedTimestamp != null ? updatedTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", displayName='" + displayName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", passwordSalt='" + passwordSalt + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", dateJoined=" + dateJoined +
                ", version=" + version +
                ", updatedTimestamp=" + updatedTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
