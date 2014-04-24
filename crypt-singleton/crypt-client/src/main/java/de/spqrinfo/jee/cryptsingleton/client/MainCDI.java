package de.spqrinfo.jee.cryptsingleton.client;

import de.spqrinfo.jee.cryptsingleton.Crypt;

import javax.ejb.EJB;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

import static java.lang.System.err;
import static java.lang.System.out;

public class MainCDI {

    private static final Pattern PATTERN = Pattern.compile("\\s+");
    @EJB
    private static Crypt crypt;

    private static String register = "";

    public static void main(final String[] args) {
        while (true) {
            try {
                if (repl()) {
                    break;
                }
            } catch (final Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static boolean repl() throws Exception {
        showUsage();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while (null != (line = reader.readLine())) {
            line = line.trim();
            if (line.isEmpty()) {
                continue;
            }
            final String[] tokens = PATTERN.split(line);
            if (null == tokens || 0 == tokens.length) {
                showUsage();
            } else if (tokens[0].equals("encrypt")) {
                encrypt(tokens);
            } else if (tokens[0].equals("decrypt")) {
                decrypt(tokens);
            } else if (tokens[0].equals("q")) {
                return true;
            } else {
                err.println("Unknown Token");
                showUsage();
            }
        }
        return false;
    }

    private static void showUsage() {
        out.println("Usage:"
                + "\nencrypt string - encrypts the given string and prints the cipher text base 64 encoded"
                + "\ndecrypt string - decrypts the given base 64 ecndoed string and prints the plain text"
                + "\nq              - quit"
                + "\n\nThe special argument $ interpolates to the last argument received from the encryption");
    }

    private static void encrypt(final String[] tokens) {
        final String plainText = tokens[1].equals("$") ? register : tokens[1];
        out.printf("Calling ecnrypt(\"%s\")\n", plainText);
        register = crypt.encrypt(plainText);
        out.printf("-> %s\n", register);
    }

    private static void decrypt(final String[] tokens) {
        final String cipherText = tokens[1].equals("$") ? register : tokens[1];
        out.printf("Calling decrypt(\"%s\")\n", cipherText);
        register = crypt.decrypt(cipherText);
        out.printf("-> %s\n", register);
    }
}
