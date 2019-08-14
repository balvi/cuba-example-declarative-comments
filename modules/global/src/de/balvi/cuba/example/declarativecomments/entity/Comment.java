package de.balvi.cuba.example.declarativecomments.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Listeners;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Listeners("dbcedc_CommentEntityListener")
@NamePattern("%s %s|user,commentedAt")
@Table(name = "DBCEDC_COMMENT")
@Entity(name = "dbcedc_Comment")
public class Comment extends StandardEntity {
    private static final long serialVersionUID = 6168029102092015614L;

    @NotNull
    @Lob
    @Column(name = "TEXT", nullable = false)
    protected String text;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "COMMENTED_AT", nullable = false)
    protected Date commentedAt;

    @NotNull
    @Column(name = "ENTITY_ID", nullable = false)
    protected UUID entityId;

    @NotNull
    @Column(name = "ENTITY_CLASS", nullable = false)
    protected String entityClass;

    public void setCommentedAt(Date commentedAt) {
        this.commentedAt = commentedAt;
    }

    public Date getCommentedAt() {
        return commentedAt;
    }


    public void setEntityId(UUID entityId) {
        this.entityId = entityId;
    }

    public UUID getEntityId() {
        return entityId;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getEntityClass() {
        return entityClass;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
    

}