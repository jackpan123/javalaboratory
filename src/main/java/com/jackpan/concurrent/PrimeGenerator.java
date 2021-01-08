package com.jackpan.concurrent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author jackpan
 * @version v1.0 2021/1/8 21:07
 */
public class PrimeGenerator implements Runnable {

    private final List<BigInteger> primes = new ArrayList<>();

    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized(this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    List<BigInteger> aSeconds() throws InterruptedException {
        PrimeGenerator generator = new PrimeGenerator();
        new Thread(generator).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }

        return generator.get();
    }

    private static final ScheduledExecutorService cancelExc =
            new ScheduledThreadPoolExecutor(2);
    public static void timeRun(final Runnable r,
                               long timeout, TimeUnit unit)
        throws InterruptedException {
        class RethrowableTask implements Runnable {
            private volatile Throwable t;
            public void run() {
                try {
                    r.run();
                } catch (Throwable t) {
                    this.t = t;
                }
            }

            void rethrow() {
                if (t != null) {
                    throw new NullPointerException();
                }
            }
        }

        RethrowableTask task = new RethrowableTask();
        final Thread taskThread = new Thread(task);
        taskThread.start();
        cancelExc.schedule(new Runnable() {
            @Override
            public void run() {
                taskThread.interrupt();
            }
        }, timeout, unit);

        taskThread.join(unit.toMillis(timeout));
        task.rethrow();
    }

    public static void main(String[] args) {
        PrimeGenerator generator = new PrimeGenerator();
        try {
            List<BigInteger> bigIntegers = generator.aSeconds();
            System.out.println();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
