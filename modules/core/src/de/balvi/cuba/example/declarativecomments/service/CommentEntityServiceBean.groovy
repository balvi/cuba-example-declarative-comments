package de.balvi.cuba.example.declarativecomments.service

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.core.global.DataManager
import com.haulmont.cuba.core.global.LoadContext
import de.balvi.cuba.example.declarativecomments.entity.Comment
import org.springframework.stereotype.Service

import javax.inject.Inject

@Service(CommentEntityService.NAME)
class CommentEntityServiceBean implements CommentEntityService {

    @Inject
    DataManager dataManager

    @Override
    Collection<Comment> getCommentsForEntity(Entity entity) {
        LoadContext<Comment> loadContext = getLoadContextForComment(entity)

        dataManager.loadList(loadContext)
    }

    protected static LoadContext<Comment> getLoadContextForComment(Entity entity) {
        def entityClass = entity.metaClass.name
        def entityId = entity.id
        LoadContext loadContext = LoadContext.create(Comment)
                .setQuery(LoadContext.createQuery('select e from dbcedc_Comment e where e.entityId = :entityId and e.entityClass = :entityClass order by e.commentedAt desc')
                        .setParameter('entityId', entityId)
                        .setParameter('entityClass', entityClass)
                )
        loadContext
    }

    @Override
    boolean hasComments(Entity entity) {
        LoadContext<Comment> loadContext = getLoadContextForComment(entity)

        dataManager.getCount(loadContext) > 0
    }
}