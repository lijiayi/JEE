package de.spqrinfo.jee.async.backend;

import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import java.math.BigInteger;
import java.util.concurrent.Future;

@Stateless
public class FibonacciCalculationBean {

    @Asynchronous
    public Future<BigInteger> asyncFibonacci(final BigInteger n) {
        System.out.println("Begin Calculation of fib(" + n + ")");
        final BigInteger r = synchronousFibonacci(n);

        System.out.println("End Calculation of fib(" + n + ")");
        return new AsyncResult<BigInteger>(r);
    }

    public BigInteger synchronousFibonacci(final BigInteger n) {
        BigInteger i = BigInteger.ONE, j = BigInteger.ZERO;

        for (BigInteger k = BigInteger.ZERO; k.compareTo(n) < 0; k = k.add(BigInteger.ONE)) {
            j = j.add(i);
            i = j.subtract(i);
        }

        return j;
    }
}
