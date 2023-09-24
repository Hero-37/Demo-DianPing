package com.dianping.utils;

public interface ILock {

    /**
     * 尝试获取锁
     * @param timeSec 锁持有的超时时间，过期后自动释放
     * @return true 代表获取锁成功；false代表获取锁失败
     */
    boolean tryLock(long timeSec);

    /**
     * 释放锁
     */
    void unlock();
}
