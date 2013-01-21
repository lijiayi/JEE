package de.spqrinfo.jee6.calc.client;

import de.spqrinfo.jee6.calc.Calc;

import javax.naming.InitialContext;

public class MainJNDI {

    /**
     * JNDI name used with glassfish.
     * @see http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#StandaloneRemoteEJB
     * @see http://glassfish.java.net/javaee5/ejb/EJB_FAQ.html#What_is_the_syntax_for_portable_global_
     */
    private static String PORTABLE_GLOBAL_JNDI_NAME =
        "java:global/calc/calc-module/CalcBean";

    public static void main(String[] args) {
        try {
            System.out.println("Creating InitialContext");
            InitialContext initialContext = new InitialContext();

            System.out.println("JNDI lookup for '" + PORTABLE_GLOBAL_JNDI_NAME + "'");
            Calc calc = (Calc) initialContext.lookup(PORTABLE_GLOBAL_JNDI_NAME);

            calc.put(13);
            System.out.println(calc.get());

        } catch (Exception ex) {
            System.err.println(ex);
        }
    }
}
