package com.datawisher.common.apache.commons.lang3.time;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class DateUtilsTests {

    private String pattern = "yyyy-MM-dd HH:mm:ss";

    /**
     *  年月日时分秒分别增加
     */
    @Test
    public void testAdd() {
        Date date = DateUtils.addDays(new Date(), 2);
        String s = DateFormatUtils.format(date, pattern);
        System.out.println(s);
    }

    /**
     * 年月日时分秒的ceiling
     */
    @Test
    public void testCeiling() {
        Date date = new Date();
        Date ceiling = DateUtils.ceiling(date, Calendar.HOUR);
        String s = DateFormatUtils.format(ceiling, pattern);
        System.out.println(s);
    }

    /**
     * fragment范围内从开始到当前的数值
     */
    @Test
    public void testGetFragmentIn() {
        Date date = new Date();
        long l = DateUtils.getFragmentInMinutes(date, Calendar.HOUR_OF_DAY);
        System.out.println(l);
    }

    /**
     * 判断日期相同
     */
    @Test
    public void testIsSame() {

    }

    /**
     * 单独设置年月日时分秒
     */
    @Test
    public void testSet() {

    }

    /**
     * 截断到年月日时分秒
     */
    @Test
    public void testTruncate() {
        Date truncate = DateUtils.truncate(new Date(), Calendar.MONTH);
        String s = DateFormatUtils.format(truncate, pattern);
        System.out.println(s);
    }

    /**
     * 取整
     */
    @Test
    public void testRound() {
        Date round = DateUtils.round(new Date(), Calendar.HOUR);
        String s = DateFormatUtils.format(round, pattern);
        System.out.println(s);
    }

}
