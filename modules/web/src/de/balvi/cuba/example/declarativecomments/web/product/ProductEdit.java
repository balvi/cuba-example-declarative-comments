package de.balvi.cuba.example.declarativecomments.web.product;

import com.haulmont.cuba.gui.screen.*;
import de.balvi.cuba.example.declarativecomments.entity.Product;

@UiController("dbcedc_Product.edit")
@UiDescriptor("product-edit.xml")
@EditedEntityContainer("productDc")
@LoadDataBeforeShow
public class ProductEdit extends StandardEditor<Product> {
}