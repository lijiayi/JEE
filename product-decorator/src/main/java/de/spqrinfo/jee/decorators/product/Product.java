package de.spqrinfo.jee.decorators.product;

/**
 * Just a virtual product interface.
 */
public interface Product {

    /**
     * @return price in euros of the product
     */
    double getPrice();

    /**
     * @return the human readable product name
     */
    String getDisplayName();

    /**
     * @return the sound when a human consumes
     */
    String getSoundOfHumanConsumption();
}
