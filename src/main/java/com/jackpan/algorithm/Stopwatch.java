package com.jackpan.algorithm;

/**
 * @author jackpan
 * @version v1.0 2020/12/30 13:04
 */
public class Stopwatch {

    private final long start;

    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
