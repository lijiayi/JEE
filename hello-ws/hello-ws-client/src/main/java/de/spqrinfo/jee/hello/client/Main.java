package de.spqrinfo.jee.hello.client;

import de.spqrinfo.jee.hello.ws.HelloService;
import de.spqrinfo.jee.hello.ws.Hello;

public class Main {

    public static void main(final String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: username");
            System.exit(1);
        }

        final HelloService helloService = new HelloService();
        final Hello hello = helloService.getHelloPort();
        final String result = hello.hello(args[0]);
        System.out.println("result " + result);
    }
}
