package com.datawisher.common.junit;

import org.junit.Assert;
import org.junit.Test;

public class AssertionsTests {

    @Test
    public void testAssertEquals() {
        String a = "arr";
        String b = "arr";
        Assert.assertEquals(a, b);
        System.out.println("OK");
    }
}
