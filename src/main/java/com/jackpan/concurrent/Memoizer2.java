package com.jackpan.concurrent;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author jackpan
 * @version v1.0 2021/1/4 22:35
 */
public class Memoizer2<A, V> implements Computable<A, V> {

    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }

        return result;
    }
}
