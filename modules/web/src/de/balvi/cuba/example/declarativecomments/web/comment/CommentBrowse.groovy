package de.balvi.cuba.example.declarativecomments.web.comment

import com.haulmont.cuba.gui.WindowParam
import com.haulmont.cuba.gui.components.AbstractLookup
import com.haulmont.cuba.gui.components.actions.CreateAction

import javax.inject.Named

class CommentBrowse extends AbstractLookup {

    @WindowParam
    UUID entityId

    @WindowParam
    String entityClass

    @WindowParam
    String entityInstanceName

    @Named("commentsTable.create")
    CreateAction createAction

    @Override
    void init(Map<String, Object> params) {
        super.init(params)

        createAction.initialValues = [
                entityId: entityId,
                entityClass: entityClass
        ]

        caption = formatMessage('browseCaption', entityInstanceName)

    }
}