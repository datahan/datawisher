package com.datawisher.concurrent;

import java.util.stream.IntStream;

/**
 * 线程的默认命名
 */
public class Tester01 {

    public static void main(String[] args) {

        IntStream.range(0, 5).boxed().map(i -> new Thread(
                () -> System.out.println(Thread.currentThread().getName())))
                .forEach(Thread::start);
    }

}
