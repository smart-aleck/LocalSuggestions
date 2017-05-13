package com.fabs.model.core;

import com.vividsolutions.jts.geom.Point;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment")
public class Comment {
    private Integer userId;
    private Suggestion suggestion;
    private String content;
    private Point location;
    private Long id;
    private Timestamp createTime;
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

    @ManyToOne
    @JoinColumn(name = "suggestionId", referencedColumnName = "id")
    public Suggestion getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(Suggestion suggestion) {
        this.suggestion = suggestion;
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
    @Type(type = "com.fabs.type.geometry.MySQL2DPointType")
    @Column(name = "location")
    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment comment = (Comment) o;

        if (userId != null ? !userId.equals(comment.userId) : comment.userId != null) return false;
        if (suggestion != null ? !suggestion.equals(comment.suggestion) : comment.suggestion != null)
            return false;
        if (content != null ? !content.equals(comment.content) : comment.content != null) return false;
        if (location != null ? !location.equals(comment.location) : comment.location != null) return false;
        if (version != null ? !version.equals(comment.version) : comment.version != null) return false;
        if (isDeleted != null ? !isDeleted.equals(comment.isDeleted) : comment.isDeleted != null) return false;
        if (id != null ? !id.equals(comment.id) : comment.id != null) return false;
        if (createTime != null ? !createTime.equals(comment.createTime) : comment.createTime != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(comment.updateTimestamp) : comment.updateTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (suggestion != null ? suggestion.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userId=" + userId +
                ", suggestionId=" + suggestion +
                ", content='" + content + '\'' +
                ", location=" + location +
                ", id=" + id +
                ", createTime=" + createTime +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
