package com.datawisher.redisson.Junit;

import org.junit.Test;

import java.math.BigDecimal;

public class MyTests {

    @Test
    public void testMap() {


    }

    @Test
    public void testBigDecimal() {
        BigDecimal a = BigDecimal.ZERO;
        BigDecimal b = BigDecimal.ZERO;
        BigDecimal c = BigDecimal.ZERO;
        BigDecimal d = BigDecimal.ZERO;
        BigDecimal e = BigDecimal.ZERO;

        b=b.add(new BigDecimal("96.9500")).stripTrailingZeros();
        c=c.add(new BigDecimal("6.9500")).stripTrailingZeros();
        d=new BigDecimal("800");
        e=d.stripTrailingZeros();


        BigDecimal withdrawAmount = new BigDecimal("206.9500").subtract(new BigDecimal("6.9400")).stripTrailingZeros();

        System.out.println(d);
        System.out.println(e);

    }

    @Test
    public void testNullAndString() {
        String a = null;
        String b = "uvw";
        System.out.println((a == null ? "": a).concat(",") +b);
    }
}
