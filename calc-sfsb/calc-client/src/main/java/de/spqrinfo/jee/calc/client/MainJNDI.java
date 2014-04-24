package de.spqrinfo.jee.calc.client;

import de.spqrinfo.jee.calc.Calc;

import javax.naming.InitialContext;

public class MainJNDI {

    /**
     * JNDI name used with glassfish.
     *
     * http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#StandaloneRemoteEJB
     * http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#What_is_the_syntax_for_portable_global_
     */
    private static final String PORTABLE_GLOBAL_JNDI_NAME =
        "java:global/calc/calc-module/CalcBean";

    public static void main(final String[] args) {
        try {
            System.out.println("Creating InitialContext");
            final InitialContext initialContext = new InitialContext();

            System.out.println("JNDI lookup for '" + PORTABLE_GLOBAL_JNDI_NAME + "'");
            final Calc calc = (Calc) initialContext.lookup(PORTABLE_GLOBAL_JNDI_NAME);

            calc.put(13);
            System.out.println(calc.get());

        } catch (final Exception ex) {
            //noinspection ThrowablePrintedToSystemOut
            System.err.println(ex);
        }
    }
}
