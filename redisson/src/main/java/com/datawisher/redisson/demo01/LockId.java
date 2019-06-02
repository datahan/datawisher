package com.datawisher.redisson.demo01;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockId {

    String value() default "";
}
