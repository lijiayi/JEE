package de.spqrinfo.jee.decorators.web;

import de.spqrinfo.jee.decorators.decorator.MilkMixProduct;
import de.spqrinfo.jee.decorators.product.Cappuccino;
import de.spqrinfo.jee.decorators.product.Coffee;
import de.spqrinfo.jee.decorators.product.Product;
import de.spqrinfo.jee.decorators.product.Tea;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Model
public class IndexBacking {

    @Inject
    private Coffee coffee;

    @Inject
    private Tea tea;

    @MilkMixProduct
    @Inject
    private Cappuccino cappuccino;

    public List<Product> getProducts() {
        final ArrayList<Product> products = new ArrayList<Product>();
        products.add(this.coffee);
        products.add(this.tea);
        products.add(this.cappuccino);
        return products;
    }
}
