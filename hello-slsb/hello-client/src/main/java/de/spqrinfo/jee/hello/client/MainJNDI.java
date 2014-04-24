package de.spqrinfo.jee.hello.client;

import de.spqrinfo.jee.hello.Hello;

import javax.naming.InitialContext;

public class MainJNDI {

    /**
     * JNDI name used with glassfish.
     * http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#StandaloneRemoteEJB
     * http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#What_is_the_syntax_for_portable_global_
     */
    private static final String PORTABLE_GLOBAL_JNDI_NAME =
        "java:global/hello/hello-module/HelloBean";

    public static void main(final String[] args) {
        try {
            System.out.println("Creating InitialContext");
            final InitialContext initialContext = new InitialContext();

            System.out.println("JNDI lookup for '" + PORTABLE_GLOBAL_JNDI_NAME + "'");
            final Hello hello = (Hello) initialContext.lookup(PORTABLE_GLOBAL_JNDI_NAME);

            System.out.println("Calling remote EJB hello");
            final String result = hello.hello();
            System.out.println("Result: " + result);

        } catch (final Exception ex) {
            //noinspection ThrowablePrintedToSystemOut
            System.err.println(ex);
        }
    }
}
