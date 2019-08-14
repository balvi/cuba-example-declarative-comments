package de.balvi.cuba.example.declarativecomments.web.comment;

import com.haulmont.cuba.gui.screen.*;
import de.balvi.cuba.example.declarativecomments.entity.Comment;

@UiController("dbcedc_Comment.edit")
@UiDescriptor("comment-edit.xml")
@EditedEntityContainer("commentDc")
@LoadDataBeforeShow
public class CommentEdit extends StandardEditor<Comment> {
}