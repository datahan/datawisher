package com.datawisher.concurrent;

import java.util.stream.IntStream;

/**
 * 命名线程
 */
public class Tester02 {

    private final static String PREFIX="JIM-";

    public static void main(String[] args) {
        IntStream.range(0, 5).mapToObj(Tester02::createThread).forEach(Thread::start);
    }

    private static Thread createThread(final int intName){
        return new Thread(() -> System.out.println(Thread.currentThread().getName()), PREFIX + intName);
    }
}
