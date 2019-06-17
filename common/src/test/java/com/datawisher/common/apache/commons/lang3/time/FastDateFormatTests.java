package com.datawisher.common.apache.commons.lang3.time;

import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;

import java.util.Date;

public class FastDateFormatTests {

    @Test
    public void testGetInstance() {
        FastDateFormat dateFormat = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss");
        String s = dateFormat.format(new Date());
        System.out.println(s);


    }
}
