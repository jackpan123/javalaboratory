package com.jackpan.concurrent;

import java.util.concurrent.CountDownLatch;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 21:43
 */
public class TestHarness {

    public long timeTasks(int nThreads, final Runnable task)
            throws InterruptedException {
        final CountDownLatch startGate = new CountDownLatch(1);
        final CountDownLatch endGate = new CountDownLatch(nThreads);

        for (int i=0; i < nThreads; ++i) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    try {
                        startGate.await();
                        try {
                            task.run();
                        } finally {
                            endGate.countDown();
                        }
                    } catch (InterruptedException ignored) {

                    }
                }
            };

            t.start();
        }

        long start = System.nanoTime();
        startGate.countDown();
        endGate.await();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        try {
            long time = new TestHarness().timeTasks(9, new Runnable() {
                @Override
                public void run() {
                    System.out.println("hahha");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });

            System.out.println(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
