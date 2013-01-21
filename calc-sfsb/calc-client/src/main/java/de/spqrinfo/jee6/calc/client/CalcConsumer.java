package de.spqrinfo.jee6.calc.client;

import de.spqrinfo.jee6.calc.Calc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class CalcConsumer {

    private final Calc calc;

    private final BufferedReader reader;

    public CalcConsumer(final Calc calc, final Reader reader) {
        if (null == calc) {
            throw new IllegalArgumentException("Argument calc may not be null");
        }
        this.calc = calc;
        this.reader = new BufferedReader(reader);
    }

    public void run() throws IOException {
        showHelp();

        String line;
        while (null != (line = this.reader.readLine())) {
            line = line.trim();
            final String[] tokens = line.split("\\s+");
            if (null == tokens || 0 == tokens.length) {
                showHelp();
            } else {
                final String cmd = tokens[0];

                if (cmd.equals("get")) {
                    doGet();
                } else if (cmd.equals("put")) {
                    doPut(tokens);
                } else if (cmd.equals("add")) {
                    doAdd(tokens);
                } else if (cmd.equals("rem")) {
                    doRemove();
                } else if (cmd.equals("q")) {
                    break;
                } else {
                    showHelp();
                }
            }
        }
    }

    private void doGet() {
        int n = this.calc.get();
        System.out.println("-> " + n);  //To change body of catch statement use File | Settings | File Templates.
    }

    private void doPut(final String[] tokens) {
        try {
            final int n = Integer.parseInt(tokens[1]);
            this.calc.put(n);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void doAdd(final String[] tokens) {
        try {
            final int n = Integer.parseInt(tokens[1]);
            this.calc.add(n);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    private void doRemove() {
        this.calc.remove();
    }

    private void showHelp() {
        System.err.println("USAGE:"
                + "\nput n - stored n into the memory"
                + "\nget   - retrieves stored value from memory "
                + "\nadd n - adds value n to value from memory and stores it"
                + "\nrem   - calls @Remove method on SFSB"
                + "\nq     - quits the client");
    }
}
