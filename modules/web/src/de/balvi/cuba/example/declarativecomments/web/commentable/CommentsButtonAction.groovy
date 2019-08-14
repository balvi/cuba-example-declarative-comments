package de.balvi.cuba.example.declarativecomments.web.commentable

import com.haulmont.cuba.gui.WindowManager
import com.haulmont.cuba.gui.components.Action
import com.haulmont.cuba.gui.components.Component
import com.haulmont.cuba.gui.components.ListComponent
import com.haulmont.cuba.gui.components.actions.ItemTrackingAction

class CommentsButtonAction extends ItemTrackingAction implements Action.HasOpenType {

    WindowManager.OpenType openType

    static final String ACTION_ID = 'commentsAction'


    CommentsButtonAction(ListComponent target) {
        this(ACTION_ID, target)
    }

    CommentsButtonAction(String id, ListComponent target) {
        super(target, id)
        icon = 'font-icon:COMMENTS_O'
        caption = ''
    }

    @Override
    void actionPerform(Component component) {
        def entity = target.singleSelected
        target.frame.openWindow(
                'dbcedc_Comment.browse',
                WindowManager.OpenType.DIALOG,
                [
                        entityId          : entity.id,
                        entityClass       : entity.metaClass.name,
                        entityInstanceName: entity.instanceName,
                ]
        )
    }

}
