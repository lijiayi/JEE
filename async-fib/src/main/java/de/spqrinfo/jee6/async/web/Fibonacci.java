package de.spqrinfo.jee6.async.web;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.concurrent.Future;

@RequestScoped
//@SessionScoped
public class Fibonacci implements Serializable {

    private BigInteger inputValue;
    private Future<BigInteger> result;

    private BigInteger inputValueSynchronous;
    private BigInteger resultSynchronous;

    @PostConstruct
    public void init() {
        System.out.println("@PostConstruct");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("@PreDestroy");
    }

    public BigInteger getInputValue() {
        return inputValue;
    }

    public void setInputValue(final BigInteger inputValue) {
        this.inputValue = inputValue;
    }

    public boolean getHaveResult() {
        return null != this.result && this.result.isDone();
    }

    public BigInteger getResult() {
        try {
            return this.result.get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void setResult(final Future<BigInteger> result) {
        this.result = result;
    }

    public BigInteger getInputValueSynchronous() {
        return inputValueSynchronous;
    }

    public void setInputValueSynchronous(final BigInteger inputValueSynchronous) {
        this.inputValueSynchronous = inputValueSynchronous;
    }

    public boolean getHaveResultSynchronous() {
        return null != this.resultSynchronous;
    }

    public BigInteger getResultSynchronous() {
        return resultSynchronous;
    }

    public void setResultSynchronous(final BigInteger resultSynchronous) {
        this.resultSynchronous = resultSynchronous;
    }

//    @Override
//    public String toString() {
//        return "Fibonacci{" +
//                "inputValue=" + inputValue +
//                ", result=" + result +
//                ", inputValueSynchronous=" + inputValueSynchronous +
//                ", resultSynchronous=" + resultSynchronous +
//                '}';
//    }
}