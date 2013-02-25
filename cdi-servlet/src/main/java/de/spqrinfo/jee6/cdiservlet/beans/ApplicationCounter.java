package de.spqrinfo.jee6.cdiservlet.beans;

import javax.enterprise.context.ApplicationScoped;
import java.util.concurrent.atomic.AtomicInteger;

@ApplicationScoped
public class ApplicationCounter {

    private final AtomicInteger counter = new AtomicInteger();

    public int incrementAndGet() {
        return this.counter.incrementAndGet();
    }
}
