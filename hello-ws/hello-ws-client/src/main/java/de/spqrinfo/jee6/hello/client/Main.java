package de.spqrinfo.jee6.hello.client;

import de.spqrinfo.jee6.hello.ws.HelloService;
import de.spqrinfo.jee6.hello.ws.Hello;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: username");
            System.exit(1);
        }

        HelloService helloService = new HelloService();
        Hello hello = helloService.getHelloPort();
        String result = hello.hello(args[0]);
        System.out.println("result " + result);
    }
}
