package com.fabs.model.core;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "suggestion", schema = "local_suggestions")
public class Suggestion {
    private Long id;
    private Integer userId;
    private String subject;
    private String content;
    private Timestamp expirationTime;
    private String suggestionType;
    private String category;
    private Point location;
    private Point displayLocation;
    private Timestamp createTime;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;
    private Set<SuggestionTag> suggestionTags;
    private Set<SuggestionAction> suggestionActions;
    private Set<Comment> comments;
    private Set<SuggestionAttachment> suggestionAttachments;

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "subject")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Basic
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "expirationTime")
    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    @Basic
    @Column(name = "suggestionType")
    public String getSuggestionType() {
        return suggestionType;
    }

    public void setSuggestionType(String suggestionType) {
        this.suggestionType = suggestionType;
    }

    @Basic
    @Column(name = "category")
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Basic
    @Type(type = "com.fabs.type.geometry.MySQL2DPointType")
    @Column(name = "location")
    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    @Basic
    @Type(type = "com.fabs.type.geometry.MySQL2DPointType")
    @Column(name = "displayLocation")
    public Point getDisplayLocation() {
        return displayLocation;
    }

    public void setDisplayLocation(Point displayLocation) {
        this.displayLocation = displayLocation;
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
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "createTime")
    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Basic
    @Column(name = "updateTimestamp")
    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "suggestion")
    public Set<SuggestionTag> getSuggestionTags() {
        return this.suggestionTags;
    }

    public void setSuggestionTags(Set<SuggestionTag> suggestionTags) {
        this.suggestionTags = suggestionTags;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "suggestion")
    public Set<SuggestionAction> getSuggestionActions() {
        return this.suggestionActions;
    }

    public void setSuggestionActions(Set<SuggestionAction> suggestionActions) {
        this.suggestionActions = suggestionActions;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "suggestion")
    public Set<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "suggestion")
    public Set<SuggestionAttachment> getSuggestionAttachments() {
        return this.suggestionAttachments;
    }

    public void setSuggestionAttachments(Set<SuggestionAttachment> suggestionAttachments) {
        this.suggestionAttachments = suggestionAttachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Suggestion that = (Suggestion) o;

        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (subject != null ? !subject.equals(that.subject) : that.subject != null) return false;
        if (content != null ? !content.equals(that.content) : that.content != null) return false;
        if (expirationTime != null ? !expirationTime.equals(that.expirationTime) : that.expirationTime != null)
            return false;
        if (suggestionType != null ? !suggestionType.equals(that.suggestionType) : that.suggestionType != null)
            return false;
        if (category != null ? !category.equals(that.category) : that.category != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (displayLocation != null ? !displayLocation.equals(that.displayLocation) : that.displayLocation != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (createTime != null ? !createTime.equals(that.createTime) : that.createTime != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(that.updateTimestamp) : that.updateTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (subject != null ? subject.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (expirationTime != null ? expirationTime.hashCode() : 0);
        result = 31 * result + (suggestionType != null ? suggestionType.hashCode() : 0);
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (displayLocation != null ? displayLocation.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Suggestion{" +
                "id=" + id +
                ", userId=" + userId +
                ", subject='" + subject + '\'' +
                ", content='" + content + '\'' +
                ", expirationTime=" + expirationTime +
                ", suggestionType='" + suggestionType + '\'' +
                ", category='" + category + '\'' +
                ", location=" + location +
                ", displayLocation=" + displayLocation +
                ", createTime=" + createTime +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
