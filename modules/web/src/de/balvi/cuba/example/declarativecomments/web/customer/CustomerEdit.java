package de.balvi.cuba.example.declarativecomments.web.customer;

import com.haulmont.cuba.gui.screen.*;
import de.balvi.cuba.example.declarativecomments.entity.Customer;

@UiController("dbcedc_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {
}