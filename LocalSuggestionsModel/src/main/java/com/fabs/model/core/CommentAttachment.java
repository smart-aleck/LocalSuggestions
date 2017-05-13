package com.fabs.model.core;

import com.vividsolutions.jts.geom.Point;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "comment_attachment")
public class CommentAttachment {
    private Long id;
    private Comment comment;
    private Integer userId;
    private Attachment attachment;
    private Point location;
    private Integer version;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "commentId", referencedColumnName = "id")
    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name = "userId")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "attachmentId", referencedColumnName = "id")
    public Attachment getAttachment() {
        return attachment;
    }

    public void setAttachment(Attachment suggestion) {
        this.attachment = attachment;
    }

    @Basic
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CommentAttachment that = (CommentAttachment) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (attachment != null ? !attachment.equals(that.attachment) : that.attachment != null) return false;
        if (location != null ? !location.equals(that.location) : that.location != null) return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(that.updateTimestamp) : that.updateTimestamp != null)
            return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (attachment != null ? attachment.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommentAttachment{" +
                "id=" + id +
                ", comment=" + comment +
                ", userId=" + userId +
                ", attachment=" + attachment +
                ", location=" + location +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
