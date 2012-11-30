package de.spqrinfo.jee6.hello.client;

import de.spqrinfo.jee6.hello.Hello;

import javax.ejb.EJB;

public class MainCDI {

    @EJB
    private static Hello hello;

    public static void main(String[] args) {
        System.out.println("Calling remote EJB hello");
        String result = hello.hello();
        System.out.println("Result: " + result);
    }
}
