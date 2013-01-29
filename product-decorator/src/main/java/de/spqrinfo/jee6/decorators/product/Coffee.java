package de.spqrinfo.jee6.decorators.product;

public class Coffee implements Product {

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
