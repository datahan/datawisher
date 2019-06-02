package com.datawisher.redisson.demo01;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface LockCut {

    String value() default "";
}
