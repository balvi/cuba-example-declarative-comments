package de.balvi.cuba.example.declarativecomments.service

import com.haulmont.cuba.core.entity.Entity
import de.balvi.cuba.example.declarativecomments.entity.Comment


interface CommentEntityService {
    String NAME = "dbcedc_CommentEntityService";

    Collection<Comment> getCommentsForEntity(Entity entity)

    boolean hasComments(Entity entity)
}