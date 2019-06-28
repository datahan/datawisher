package com.datawisher.concurrent.chapter03;

/**
 * 线程优先级，范围从1到10
 * 通过设置ThreadGroup的setMaxPriority方法可以指定线程组的最大优先级，如果在该组中的线程大于这个数，则会强制改回这个最大值。
 */
public class ThreadPriority {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("t1");
            }
        });
        t1.setPriority(3);

        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("t2");
            }
        });
        t2.setPriority(10);

        t1.start();
        t2.start();
    }
}
