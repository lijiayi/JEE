package de.spqrinfo.jee6.async.backend;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

/**
 * TODO add docs
 *
 * @author marcus
 */
public class FibonacciCalculationBeanTest {

    private FibonacciCalculationBean fib;

    @Before
    public void before() {
        this.fib = new FibonacciCalculationBean();
    }

    @After
    public void after() {
        this.fib = null;
    }

    @Test
    public void testSynchronousFibonacci() throws Exception {
        final BigInteger expected = new BigInteger("2791715456571051233611642553");
        final BigInteger inputN = new BigInteger("133");
        final BigInteger actual = fib.synchronousFibonacci(inputN);
        Assert.assertEquals(expected, actual);
    }
}
