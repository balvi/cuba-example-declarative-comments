package de.balvi.cuba.example.declarativecomments.web.commentable

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.ButtonsPanel
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.Window
import de.balvi.cuba.declarativecontrollers.web.browse.BrowseAnnotationExecutor
import org.springframework.stereotype.Component

import javax.inject.Inject
import java.lang.annotation.Annotation

@Component
class CommentableBrowseAnnotationExecutor implements BrowseAnnotationExecutor<Commentable> {

    @Inject
    ButtonsPanelHelper buttonsPanelHelper


    @Override
    void init(Commentable annotation, Window.Lookup browse, Map<String, Object> params) {
//        Button button = buttonsPanelHelper.getOrCreateButton(editor, annotation.buttonId(), annotation.buttonsPanel())
        ListComponent listComponent = browse.getComponent(annotation.listComponent()) as ListComponent
        def action = new CommentsButtonAction(listComponent)
        listComponent.addAction(action)
        if (annotation.buttonsPanel()) {
            ButtonsPanel buttonsPanel = browse.getComponent(annotation.buttonsPanel()) as ButtonsPanel
            Button dokumentButton = buttonsPanelHelper.createButton(annotation.buttonId(), buttonsPanel, [])
            dokumentButton.action = action
        }
//        button.action = new CommentsButtonAction(browse)
    }

    @Override
    boolean supports(Annotation annotation) {
        annotation instanceof Commentable
    }


    @Override
    void ready(Commentable annotation, Window.Lookup browse, Map<String, Object> params) {

    }
}
