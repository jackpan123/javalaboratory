package com.jackpan.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author jackpan
 * @version v1.0 2021/1/23 16:15
 */
public class ThreadOverheadTest {

    public static void main(String[] args) throws InterruptedException {
        runWithMultiThreadPool();
    }

    public static void runWithMultiThread() throws InterruptedException {
        long begin = System.currentTimeMillis();
        AtomicInteger result = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i=0; i<100000; ++i) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    result.incrementAndGet();
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(result.get());
        long end = System.currentTimeMillis();
        // 5558ms
        System.out.println(end - begin);
    }

    public static void runWithMainThread() throws InterruptedException {
        long begin = System.currentTimeMillis();
        AtomicInteger result = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i=0; i<100000; ++i) {
            result.incrementAndGet();
            countDownLatch.countDown();
        }
        countDownLatch.await();
        System.out.println(result.get());
        long end = System.currentTimeMillis();
        // 9ms
        System.out.println(end - begin);
    }

    public static void runWithMultiThreadPool() throws InterruptedException {
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger result = new AtomicInteger();
        CountDownLatch countDownLatch = new CountDownLatch(10000);
        for (int i=0; i<100000; ++i) {
            executorService.submit(new Runnable() {
                @Override
                public void run() {
                    result.incrementAndGet();
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        System.out.println(result.get());
        long end = System.currentTimeMillis();
        // 558ms
        System.out.println(end - begin);
        executorService.shutdown();
    }
}
