package de.spqrinfo.jee.calc;

public interface Calc {

    /**
     * Puts an integer into the memory register.
     * @param n value to store
     */
    void put(final int n);

    /**
     * Gets the value from the memory register.
     * @return stored value
     */
    int get();

    /**
     * Adds an integer to the value from the memory register
     * and stores the result into the memory register.
     * @param n value to add and store
     */
    void add(final int n);

    /**
     * Removes the state and cleans up the resources held on the server
     * side.
     */
    void remove();
}
