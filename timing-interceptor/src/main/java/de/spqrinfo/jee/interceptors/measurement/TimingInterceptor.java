package de.spqrinfo.jee.interceptors.measurement;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

@TimeMeasurement @Interceptor
public class TimingInterceptor {

    @AroundInvoke
    public Object doSomething(final InvocationContext invocationContext) throws Exception {
        final Object target = invocationContext.getTarget();
        final Method method = invocationContext.getMethod();

        final long start = System.currentTimeMillis();
        try {
            return invocationContext.proceed();
        } finally {
            final long end = System.currentTimeMillis();
            final long delta = end - start;

            System.out.println("Timed method call "
                    + target.getClass().getSimpleName()
                    + "#" + method.getName()
                    + " " + delta + " ms");
        }
    }
}

