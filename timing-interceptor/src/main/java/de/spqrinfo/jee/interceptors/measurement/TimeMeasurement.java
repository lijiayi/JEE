package de.spqrinfo.jee.interceptors.measurement;

import javax.interceptor.InterceptorBinding;
import java.lang.annotation.*;

@InterceptorBinding
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface TimeMeasurement {
}
