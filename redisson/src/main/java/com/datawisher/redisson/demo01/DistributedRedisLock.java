package com.datawisher.redisson.demo01;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 分布式Redis锁的Ression实现
 *
 * @author Jim Han
 */
@Component
public class DistributedRedisLock {

    /**
     * 从配置类中获取redisson对象
     */
    private static Redisson redisson = RedissonManager.getRedisson();
    private static final String LOCK_TITLE = "redisLock_";

    /**
     * 加锁
     * @param lockName
     * @return
     */
    public boolean acquire(String lockName){
        //声明key对象
        String key = LOCK_TITLE + lockName;
        //获取锁对象
        RLock myLock = redisson.getLock(key);
        //加锁，并且设置锁过期时间，防止死锁的产生
        myLock.lock(2, TimeUnit.MINUTES);
        System.err.println("======lock======"+Thread.currentThread().getName());
        //加锁成功
        return true;
    }

    /**
     * 释放锁
     * @param lockName
     */
    public void release(String lockName){
        //必须是和加锁时的同一个key
        String key = LOCK_TITLE + lockName;
        //获取所对象
        RLock myLock = redisson.getLock(key);
        //释放锁（解锁）
        myLock.unlock();
        System.err.println("======unlock======"+Thread.currentThread().getName());
    }
}
