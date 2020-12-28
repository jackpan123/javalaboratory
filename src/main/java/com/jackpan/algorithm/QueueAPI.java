package com.jackpan.algorithm;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 17:46
 */
public interface QueueAPI<E> {

    void enqueue(E e);

    E dequeue();

    int size();

    boolean isEmpty();
}
