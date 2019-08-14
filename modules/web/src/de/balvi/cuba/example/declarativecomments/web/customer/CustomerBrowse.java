package de.balvi.cuba.example.declarativecomments.web.customer;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import de.balvi.cuba.example.declarativecomments.entity.Customer;
import de.balvi.cuba.example.declarativecomments.web.commentable.Commentable;
import de.balvi.cuba.example.declarativecomments.web.iconcommented.IconCommentedEntities;

import javax.inject.Inject;

@Commentable(listComponent = "customersTable")
@UiController("dbcedc_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {

    @IconCommentedEntities(icon = "font-icon:COMMENTING")
    @Inject
    private GroupTable<Customer> customersTable;
}