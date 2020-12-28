package com.jackpan.algorithm;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 13:03
 */
public interface StackAPI<E> {

    void push(E e);

    E peek();

    E pop();

    int size();

    boolean isEmpty();
}
