package com.jackpan.concurrent;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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
