package de.spqrinfo.jee6.calc.module;

import de.spqrinfo.jee6.calc.Calc;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.concurrent.TimeUnit;

@Stateful
@StatefulTimeout(value = 30, unit = TimeUnit.SECONDS)
@Remote(Calc.class)
public class CalcBean implements Calc {

    private Integer register = null;

    @Override
    public void put(final int n) {
        this.register = n;
    }


    @Override
    public int get() {
        return this.register;
    }

    @Override
    public void add(final int n) {
        this.register += n;
    }

    @PostConstruct
    public void postConstruct() {
        System.out.println(this.getClass().getSimpleName() + " PostConstruct method called");
        this.register = 0;
    }

    @PreDestroy
    public void preDestory() {
        System.out.println(this.getClass().getSimpleName() + " PreDestory method called");
    }

    @Remove
    @Override
    public void remove() {
        System.out.println(this.getClass().getSimpleName() + " Remove method called");
        this.register = 666;
    }
}
