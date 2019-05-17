package com.datawisher.common;

import com.datawisher.common.service.MyService;
import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LocalTests {

    @InjectMocks
    private MyService myService;

    @Test
    public void testMockito() {

        //You can mock concrete classes, not just interfaces
        LinkedList mockedList = mock(LinkedList.class);

        //stubbing
        when(mockedList.get(0)).thenReturn("first");
        /*when(mockedList.get(1)).thenThrow(new RuntimeException());*/

        //following prints "first"
        System.out.println(mockedList.get(0));

        /*//following throws runtime exception
        System.out.println(mockedList.get(1));*/

        //following prints "null" because get(999) was not stubbed
        System.out.println(mockedList.get(999));

        //Although it is possible to verify a stubbed invocation, usually it's just redundant
        //If your code cares what get(0) returns, then something else breaks (often even before verify() gets executed).
        //If your code doesn't care what get(0) returns, then it should not be stubbed. Not convinced? See here.
        verify(mockedList).get(0);
    }

    @Test
    public void testAssert() {
        MyService myService = new MyService();
        String foo = myService.foo();
        if ("foo one".equals(foo)) {
            Assert.assertEquals("foo one", foo);
        } else {
            Assert.assertEquals("foo null", foo);
        }
    }

    @Test
    public void testBooleanType() {
        Boolean bt = Boolean.TRUE;
        Boolean bf = Boolean.FALSE;
        boolean t = true;
        boolean f = false;

        if (bt) {
            System.out.println("Boolean true");
        }
        if (bf) {
            System.out.println("Boolean false");
        }
        if (t) {
            System.out.println("boolean true");
        }
        if (f) {
            System.out.println("boolean false");
        }
    }

    @Test
    public void testMap() throws JsonProcessingException {

        Map<String,String> map = new HashMap<String,String>();
        ObjectMapper objectMapper = new ObjectMapper();
        map.put("b", "b");
        map.put("a", "a");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        map.put("occurTime", sdf.format(new Date()));
        System.out.println("print map: " + map);
        String jsonStr = objectMapper.writeValueAsString(map);
        System.out.println("print json: " + jsonStr);
    }

    @Test
    public void testBigDecimal() {
        BigDecimal db1 = BigDecimal.valueOf(12.34567);
        System.out.println(db1);
        String s = String.valueOf(db1);
        System.out.println(s);
    }

    @Test
    public void testFor() {
        StringBuffer sb = new StringBuffer();
        List<String> list = new LinkedList<>();
        list.add("abc");
        list.add("efg");
        list.add("hij");
        list.add("klm");
        list.add("nop");
        list.add("qrs");
        list.add("tuv");

        for (String str : list) {
            sb.append(str);
            System.out.println(str);
        }

    }
}
