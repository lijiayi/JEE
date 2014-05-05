package de.spqrinfo.jee.decorators.decorator;

import de.spqrinfo.jee.decorators.product.Product;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

@Decorator
public abstract class ProductWithMilkDecorator implements Product {

    @MilkMixProduct
    @Delegate
    @Inject
    // @Any
    private Product product;

    @Override
    public double getPrice() {
        return 0.5d + this.product.getPrice();
    }

    @Override
    public String getDisplayName() {
        return this.product.getDisplayName() + " with Milk";
    }

    // Not implementing String getSoundOfHumanConsumption()

    @Override
    public String toString() {
        return "ProductWithMilkDecorator{" +
                "product=" + this.product +
                '}';
    }
}

