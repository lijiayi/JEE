package de.spqrinfo.jee6.hello.module;

import de.spqrinfo.jee6.hello.Hello;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Stateless
@Remote(Hello.class)
public class HelloBean implements Hello {

    @Override
    public String hello() {
        return "Hello, World!";
    }
}
