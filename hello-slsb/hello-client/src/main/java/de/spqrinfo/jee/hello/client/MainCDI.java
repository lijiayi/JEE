package de.spqrinfo.jee.hello.client;

import de.spqrinfo.jee.hello.Hello;

import javax.ejb.EJB;

public class MainCDI {

    @EJB
    private static Hello hello;

    public static void main(final String[] args) {
        System.out.println("Calling remote EJB hello");
        final String result = hello.hello();
        System.out.println("Result: " + result);
    }
}
