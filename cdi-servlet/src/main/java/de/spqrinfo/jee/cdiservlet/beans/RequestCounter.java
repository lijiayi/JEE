package de.spqrinfo.jee.cdiservlet.beans;

import javax.enterprise.context.RequestScoped;
import java.util.concurrent.atomic.AtomicInteger;

@RequestScoped
public class RequestCounter {

    private final AtomicInteger counter = new AtomicInteger();

    public int incrementAndGet() {
        return this.counter.incrementAndGet();
    }
}
