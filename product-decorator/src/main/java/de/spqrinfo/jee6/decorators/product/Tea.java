package de.spqrinfo.jee6.decorators.product;

public class Tea implements Product {

    @Override
    public double getPrice() {
        return 2.0d;
    }

    @Override
    public String getDisplayName() {
        return "Tea";
    }

    @Override
    public String getSoundOfHumanConsumption() {
        return "Smack";
    }
}
