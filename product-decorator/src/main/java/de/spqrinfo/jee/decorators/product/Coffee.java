package de.spqrinfo.jee.decorators.product;

public class Coffee implements de.spqrinfo.jee.decorators.product.Product {

    @Override
    public double getPrice() {
        return 1.0d;
    }

    @Override
    public String getDisplayName() {
        return "Coffee";
    }

    @Override
    public String getSoundOfHumanConsumption() {
        return "Slurp";
    }

    @Override
    public String toString() {
        return "Coffee{}";
    }
}
