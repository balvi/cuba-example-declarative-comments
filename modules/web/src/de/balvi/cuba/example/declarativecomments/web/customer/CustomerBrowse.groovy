package de.balvi.cuba.example.declarativecomments.web.customer

import com.haulmont.cuba.gui.components.Table
import de.balvi.cuba.declarativecontrollers.web.browse.AnnotatableAbstractLookup
import de.balvi.cuba.example.declarativecomments.entity.Customer
import de.balvi.cuba.example.declarativecomments.web.iconcommented.IconCommentedEntities
import de.balvi.cuba.example.declarativecomments.web.commentable.Commentable

import javax.inject.Inject

@Commentable(listComponent = 'customersTable')
class CustomerBrowse extends AnnotatableAbstractLookup {

    @IconCommentedEntities(icon = 'font-icon:COMMENTING')
    @Inject
    Table<Customer> customersTable
}