package de.balvi.cuba.example.declarativecomments.web.product;

import com.haulmont.cuba.gui.screen.*;
import de.balvi.cuba.example.declarativecomments.entity.Product;
import de.balvi.cuba.example.declarativecomments.web.commentable.Commentable;

@Commentable(listComponent = "productsTable")
@UiController("dbcedc_Product.browse")
@UiDescriptor("product-browse.xml")
@LookupComponent("productsTable")
@LoadDataBeforeShow
public class ProductBrowse extends StandardLookup<Product> {
}