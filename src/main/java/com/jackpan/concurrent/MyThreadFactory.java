package com.jackpan.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * @author jackpan
 * @version v1.0 2021/1/20 21:53
 */
public class MyThreadFactory implements ThreadFactory {
    private final String poolName;

    public MyThreadFactory(String poolName) {
        this.poolName = poolName;
    }

    public Thread newThread(Runnable runnable) {
        return new MyAppThread(runnable, poolName);
    }
}
