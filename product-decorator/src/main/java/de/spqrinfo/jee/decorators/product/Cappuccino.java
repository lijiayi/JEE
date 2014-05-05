package de.spqrinfo.jee.decorators.product;

import de.spqrinfo.jee.decorators.decorator.MilkMixProduct;

@MilkMixProduct
public class Cappuccino implements de.spqrinfo.jee.decorators.product.Product {

    @Override
    public double getPrice() {
        return 2.5d;
    }

    @Override
    public String getDisplayName() {
        return "Cappuccino";
    }

    @Override
    public String getSoundOfHumanConsumption() {
        return "Hmmmm";
    }

    @Override
    public String toString() {
        return "Cappuccino{}";
    }
}
