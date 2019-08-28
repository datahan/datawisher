package com.datawisher.concurrent.chapter05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.lang.Thread.currentThread;
import static java.util.concurrent.ThreadLocalRandom.current;

public class BooleanLockTest {

    // 定义booleanLock
    private final BooleanLock lock = new BooleanLock();

    public void syncMethod() {

        try {
            lock.lock();
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock and release lock after " + randomInt + " seconds");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void syncMethodTimeoutable() {

        try {
            lock.lock(1000);
            int randomInt = current().nextInt(10);
            System.out.println(currentThread() + " get the lock and release lock after " + randomInt + " seconds");
            TimeUnit.SECONDS.sleep(randomInt);
        } catch (InterruptedException | TimeoutException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        BooleanLockTest booleanLockTest = new BooleanLockTest();

        // 多个线程通过lock争抢锁
        /*IntStream.range(0, 10)
                .mapToObj(i -> new Thread(booleanLockTest::syncMethod))
                .forEach(Thread::start);*/

        // 可中断被阻塞的线程
        /*new Thread(booleanLockTest::syncMethod, "T1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(booleanLockTest::syncMethod, "T2");
        t2.start();
        t2.interrupt();*/

        // 获取锁超时
        new Thread(booleanLockTest::syncMethod, "T1").start();
        try {
            TimeUnit.MILLISECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(booleanLockTest::syncMethodTimeoutable, "T2");
        t2.start();
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
