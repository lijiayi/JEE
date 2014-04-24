package de.spqrinfo.jee.calc.client;

import de.spqrinfo.jee.calc.Calc;

import javax.ejb.EJB;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainCDI {

    @EJB
    private static Calc calc;

    public static void main(final String[] args) throws IOException {
        final CalcConsumer consumer = new CalcConsumer(MainCDI.calc, new InputStreamReader(System.in));
        consumer.run();
    }
}
