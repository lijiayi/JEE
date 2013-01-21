package de.spqrinfo.jee6.calc.client;

import de.spqrinfo.jee6.calc.Calc;

import javax.ejb.EJB;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainCDI {

    @EJB
    private static Calc calc;

    public static void main(String[] args) throws IOException {
        final CalcConsumer consumer = new CalcConsumer(MainCDI.calc, new InputStreamReader(System.in));
        consumer.run();
    }
}
