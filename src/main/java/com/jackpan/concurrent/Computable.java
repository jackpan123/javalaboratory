package com.jackpan.concurrent;

/**
 * @author jackpan
 * @version v1.0 2021/1/4 22:22
 */
public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
