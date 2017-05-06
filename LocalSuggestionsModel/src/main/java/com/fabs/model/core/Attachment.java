package com.fabs.model.core;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table(name = "attachment", schema = "local_suggestions")
public class Attachment {
    private String attachmentType;
    private String attachmentName;
    private byte[] attachment;
    private String attachmentMetaData;
    private Long id;
    private Integer version = 0;
    private Timestamp updateTimestamp = null;
    private Boolean isDeleted = false;
    private Set<SuggestionAttachment> suggestionAttachments;
    private Set<CommentAttachment> commentAttachments;

    @Basic
    @Column(name = "attachmentType")
    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    @Basic
    @Column(name = "attachmentName")
    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    @Basic
    @Column(name = "attachment")
    public byte[] getAttachment() {
        return attachment;
    }

    public void setAttachment(byte[] attachment) {
        this.attachment = attachment;
    }

    @Basic
    @Column(name = "attachmentMetaData")
    public String getAttachmentMetaData() {
        return attachmentMetaData;
    }

    public void setAttachmentMetaData(String attachmentMetaData) {
        this.attachmentMetaData = attachmentMetaData;
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
    @Column(name = "updateTimestamp")
    public Timestamp getUpdateTimestamp() {
        return updateTimestamp;
    }

    public void setUpdateTimestamp(Timestamp updateTimestamp) {
        this.updateTimestamp = updateTimestamp;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attachment")
    public Set<SuggestionAttachment> getSuggestionAttachments() {
        return this.suggestionAttachments;
    }

    public void setSuggestionAttachments(Set<SuggestionAttachment> suggestionAttachments) {
        this.suggestionAttachments = suggestionAttachments;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "attachment")
    public Set<CommentAttachment> getCommentAttachments() {
        return this.commentAttachments;
    }

    public void setCommentAttachments(Set<CommentAttachment> commentAttachments) {
        this.commentAttachments = commentAttachments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Attachment that = (Attachment) o;

        if (attachmentType != null ? !attachmentType.equals(that.attachmentType) : that.attachmentType != null)
            return false;
        if (attachmentName != null ? !attachmentName.equals(that.attachmentName) : that.attachmentName != null)
            return false;
        if (!Arrays.equals(attachment, that.attachment)) return false;
        if (attachmentMetaData != null ? !attachmentMetaData.equals(that.attachmentMetaData) : that.attachmentMetaData != null)
            return false;
        if (version != null ? !version.equals(that.version) : that.version != null) return false;
        if (isDeleted != null ? !isDeleted.equals(that.isDeleted) : that.isDeleted != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (updateTimestamp != null ? !updateTimestamp.equals(that.updateTimestamp) : that.updateTimestamp != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = attachmentType != null ? attachmentType.hashCode() : 0;
        result = 31 * result + (attachmentName != null ? attachmentName.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(attachment);
        result = 31 * result + (attachmentMetaData != null ? attachmentMetaData.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (isDeleted != null ? isDeleted.hashCode() : 0);
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (updateTimestamp != null ? updateTimestamp.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Attachment{" +
                "attachmentType='" + attachmentType + '\'' +
                ", attachmentName='" + attachmentName + '\'' +
                ", attachment=" + Arrays.toString(attachment) +
                ", attachmentMetaData='" + attachmentMetaData + '\'' +
                ", id=" + id +
                ", version=" + version +
                ", updateTimestamp=" + updateTimestamp +
                ", isDeleted=" + isDeleted +
                '}';
    }
}
