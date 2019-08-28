package com.datawisher.concurrent.chapter05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

import static java.lang.System.currentTimeMillis;
import static java.lang.Thread.currentThread;

public class BooleanLock {

    private Thread currentThread;

    private boolean locked = false;

    private final List<Thread> blockedList = new ArrayList<>();

    /**
     * 加锁
     * @throws InterruptedException
     */
    public void lock() throws InterruptedException {

        synchronized (this) {
            while (locked) {
                // 暂存当前线程
                final Thread tempThread = currentThread();
                try {
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                    }
                    this.wait();
                } catch (InterruptedException e) {
                    // 避免被中断后，当前线程还在blockedList中，造成内存泄漏
                    blockedList.remove(tempThread);
                    e.printStackTrace();
                }
            }

            blockedList.remove(currentThread);
            this.locked = true;
            this.currentThread = currentThread();
        }
    }

    /**
     * 加锁
     * @param mills
     * @throws InterruptedException
     * @throws TimeoutException
     */
    public void lock(long mills) throws InterruptedException, TimeoutException {

        synchronized (this) {
            if (mills < 0) {
                this.lock();
            } else {
                long remainMills = mills;
                long endMills = currentTimeMillis() + remainMills;
                while (locked) {
                    if (remainMills <= 0) {
                        blockedList.remove(currentThread());
                        throw new TimeoutException("can not get the lock during " + mills + " ms.");
                    }
                    if (!blockedList.contains(currentThread())) {
                        blockedList.add(currentThread());
                    }
                    this.wait(remainMills);
                    remainMills = endMills - currentTimeMillis();
                }

                blockedList.remove(currentThread());
                this.locked = true;
                this.currentThread = currentThread();
            }
        }
    }

    /**
     * 释放锁
     */
    public void unlock() {

        synchronized (this) {
            if (currentThread == currentThread()) {
                this.locked = false;
                Optional.of(currentThread().getName() + " release the lock.")
                        .ifPresent(System.out::println);
                this.notifyAll();
            }
        }
    }

    public List<Thread> getBlockedThreads() {
        return Collections.unmodifiableList(blockedList);
    }
}
