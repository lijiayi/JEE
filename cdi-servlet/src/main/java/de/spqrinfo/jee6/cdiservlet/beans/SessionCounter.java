package de.spqrinfo.jee6.cdiservlet.beans;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;

@SessionScoped
public class SessionCounter implements Serializable {

    private final AtomicInteger counter = new AtomicInteger();

    public int incrementAndGet() {
        return this.counter.incrementAndGet();
    }
}
