package de.spqrinfo.jee.decorators.decorator;

import javax.inject.Qualifier;
import java.lang.annotation.*;

@Qualifier
@Inherited
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface MilkMixProduct {

}
