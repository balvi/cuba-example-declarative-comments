package de.balvi.cuba.example.declarativecomments.web.iconcommented

import com.haulmont.cuba.core.entity.Entity
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.Table
import com.haulmont.cuba.gui.components.Window
import de.balvi.cuba.declarativecontrollers.web.annotationexecutor.browse.BrowseFieldAnnotationExecutor
import de.balvi.cuba.example.declarativecomments.service.CommentEntityService
import org.springframework.stereotype.Component

import javax.inject.Inject
import java.lang.annotation.Annotation

@Component
class IconCommentedEntitiesFieldAnnotationBrowseExecutor implements BrowseFieldAnnotationExecutor<IconCommentedEntities, Table> {

    @Inject
    CommentEntityService commentEntityService

    @Override
    boolean supports(Annotation annotation) {
        return annotation instanceof IconCommentedEntities
    }

    @Override
    void init(IconCommentedEntities annotation, Window.Lookup browse, Table target, Map<String, Object> params) {

        target.iconProvider = new ListComponent.IconProvider<Entity>() {
            @Override
            String getItemIcon(Entity entity) {
                boolean hasComments = commentEntityService.hasComments(entity)
                hasComments ? annotation.icon() : ''
            }
        }
    }

    @Override
    void ready(IconCommentedEntities annotation, Window.Lookup browse, Table target, Map<String, Object> params) {

    }
}
