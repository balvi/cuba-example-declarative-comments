package de.balvi.cuba.example.declarativecomments.web.comment;

import com.haulmont.cuba.gui.screen.*;
import de.balvi.cuba.example.declarativecomments.entity.Comment;

@UiController("dbcedc_Comment.browse")
@UiDescriptor("comment-browse.xml")
@LookupComponent("commentsTable")
@LoadDataBeforeShow
public class CommentBrowse extends StandardLookup<Comment> {

//
//    @WindowParam
//    UUID entityId
//
//    @WindowParam
//    String entityClass
//
//    @WindowParam
//    String entityInstanceName
//
//    @Named("commentsTable.create")
//    CreateAction createAction
//
//    @Override
//    void init(Map<String, Object> params) {
//        super.init(params)
//
//        createAction.initialValues = [
//        entityId: entityId,
//                entityClass: entityClass
//        ]
//
//        caption = formatMessage('browseCaption', entityInstanceName)
//
//    }

}