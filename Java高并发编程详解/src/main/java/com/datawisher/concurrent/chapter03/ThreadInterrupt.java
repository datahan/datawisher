package com.datawisher.concurrent.chapter03;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {

            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("Oh, i am be interrupted.");
            }
        });

        thread.start();

        TimeUnit.MILLISECONDS.sleep(2000);
        thread.interrupt();
    }
}
