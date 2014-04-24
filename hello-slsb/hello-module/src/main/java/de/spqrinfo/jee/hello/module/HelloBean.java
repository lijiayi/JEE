package de.spqrinfo.jee.hello.module;

import de.spqrinfo.jee.hello.Hello;

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
