package com.jackpan.concurrent;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 22:10
 */
public class BoundedHashSet<T> {

    private final Set<T> set;

    private final Semaphore sem;

    public BoundedHashSet(int bound) {
        this.set = Collections.synchronizedSet(new HashSet<>());
        sem = new Semaphore(bound);
    }

    public boolean add(T o) throws InterruptedException {
        sem.acquire();
        boolean wasAdded = false;
        try {
            wasAdded = set.add(o);
            return wasAdded;
        } finally {
            if (!wasAdded) {
                sem.release();
            }
        }
    }

    public boolean remove(Object o) {
        boolean wasRemoved = set.remove(o);
        if (wasRemoved) {
            sem.release();
        }

        return wasRemoved;
    }

    public static void main(String[] args) throws InterruptedException {
        final BoundedHashSet<String> boundedHashSet = new BoundedHashSet<>(5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i<6; ++i) {
                    try {
                        boundedHashSet.add("fff" + i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("添加完成");
            }
        }).start();

        Thread.sleep(3000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                boundedHashSet.remove("fff1");
                System.out.println("移除成功");
            }
        }).start();


    }
}
