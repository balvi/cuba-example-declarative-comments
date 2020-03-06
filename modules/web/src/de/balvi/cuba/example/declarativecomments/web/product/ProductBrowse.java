package de.balvi.cuba.example.declarativecomments.web.product;

import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup;
import de.balvi.cuba.example.declarativecomments.web.commentable.Commentable;

@Commentable(listComponent = "productsTable")
public class ProductBrowse extends AnnotatableAbstractLookup {
}