package de.balvi.cuba.example.declarativecomments.web.customer

import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup
import de.balvi.cuba.example.declarativecomments.web.commentable.Commentable

@Commentable(listComponent = 'customersTable')
class CustomerBrowse extends AnnotatableAbstractLookup {
}