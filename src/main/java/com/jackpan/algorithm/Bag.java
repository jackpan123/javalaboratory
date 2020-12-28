package com.jackpan.algorithm;

import java.util.*;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 18:56
 */
public class Bag<E> implements Iterable<E> {

    private Node first;

    private class Node {
        E item;
        Node next;
    }

    public void add(E e) {
        Node oldFirst = first;
        first = new Node();
        first.item = e;
        first.next = oldFirst;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<E> {

        private Bag.Node current = first;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return current != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public E next() {
            @SuppressWarnings("unchecked") E e = (E) current.item;
            current = current.next;
            return e;
        }

        /**
         * Removes from the underlying collection the last element returned
         * by this iterator (optional operation).  This method can be called
         * only once per call to {@link #next}.  The behavior of an iterator
         * is unspecified if the underlying collection is modified while the
         * iteration is in progress in any way other than by calling this
         * method.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this iterator
         * @throws IllegalStateException         if the {@code next} method has not
         *                                       yet been called, or the {@code remove} method has already
         *                                       been called after the last call to the {@code next}
         *                                       method
         * @implSpec The default implementation throws an instance of
         * {@link UnsupportedOperationException} and performs no other action.
         */
        @Override
        public void remove() {

        }
    }

    public static void main(String[] args) {
        test();
    }

    public static void test() {
        int[] arr = new int[]{1,2,3,4,5,6};
        List<Map<String, Integer>> result = new ArrayList<>();
        for (int i=0; i<arr.length-1; i=i+2) {
            Map<String, Integer> map = new HashMap<>();
            map.put("LEFT", arr[i]);
            map.put("RIGHT", arr[i+1]);
            result.add(map);
        }

        result.forEach((e) -> e.forEach((k, v) -> System.out.println(k + ":" + v)));
    }
}
