package de.balvi.cuba.example.declarativecomments.listener

import com.haulmont.cuba.core.global.TimeSource
import com.haulmont.cuba.core.global.UserSessionSource
import org.springframework.stereotype.Component
import com.haulmont.cuba.core.listener.BeforeInsertEntityListener
import com.haulmont.cuba.core.EntityManager
import de.balvi.cuba.example.declarativecomments.entity.Comment

import javax.inject.Inject

@Component("dbcedc_CommentEntityListener")
public class CommentEntityListener implements BeforeInsertEntityListener<Comment> {

    @Inject
    UserSessionSource userSessionSource

    @Inject
    TimeSource timeSource

    @Override
    public void onBeforeInsert(Comment entity, EntityManager entityManager) {
        entity.user = userSessionSource.userSession.currentOrSubstitutedUser
        entity.commentedAt = timeSource.currentTimestamp()
    }

}