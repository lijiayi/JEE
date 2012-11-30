package de.spqrinfo.jee6.hello.client;

import de.spqrinfo.jee6.hello.Hello;

import javax.naming.InitialContext;

public class MainJNDI {

    /**
     * JNDI name used with glassfish.
     * @see http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#StandaloneRemoteEJB
     * @see http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#What_is_the_syntax_for_portable_global_
     */
    private static String PORTABLE_GLOBAL_JNDI_NAME =
        "java:global/hello/hello-module/HelloBean";

    public static void main(String[] args) {
        try {
            System.out.println("Creating InitialContext");
            InitialContext initialContext = new InitialContext();

            System.out.println("JNDI lookup for '" + PORTABLE_GLOBAL_JNDI_NAME + "'");
            Hello hello = (Hello) initialContext.lookup(PORTABLE_GLOBAL_JNDI_NAME);

            System.out.println("Calling remote EJB hello");
            String result = hello.hello();
            System.out.println("Result: " + result);

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
