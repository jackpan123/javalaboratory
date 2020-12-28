package com.jackpan.algorithm;


import org.w3c.dom.Node;

import java.util.Iterator;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 17:48
 */
public class Queue<E> implements Iterable<E>, QueueAPI<E> {

    private Node first;

    private Node last;

    private int size;

    private class Node<E> {


        private Node next;

        private E item;

        public Node(){}

        public Node(Node next, E item) {
            this.next = next;
            this.item = item;
        }


        /**
         * Gets next.
         *
         * @return Value of next.
         */
        public Node<E> getNext() {
            return this.next;
        }

        /**
         * Sets next.
         *
         * @param next Simple param.
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Gets item.
         *
         * @return Value of item.
         */
        public E getItem() {
            return this.item;
        }

        /**
         * Sets item.
         *
         * @param item Simple param.
         */
        public void setItem(E item) {
            this.item = item;
        }
    }

    @Override
    public void enqueue(E e) {
        Node oldLast = last;
        last = new Node(null, e);

       if (isEmpty()) {
           first = last;
       } else {
           oldLast.next = last;
       }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            throw new NullPointerException("Queue is empty");
        }
        @SuppressWarnings("unchecked") E item = (E) first.getItem();
        first = first.getNext();
        size--;
        if (isEmpty()) {
            last = null;
        }
        return item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<E> iterator() {
        return new ListIterator<>();
    }

    private class ListIterator<E> implements Iterator<E> {

        private Queue.Node current = first;
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
            @SuppressWarnings("unchecked") E item = (E) current.getItem();
            current = current.getNext();
            return item;
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
        Queue<String> queue = new Queue<>();
        queue.enqueue("aaa");
        queue.enqueue("bbb");
        queue.enqueue("ccc");
        for (String e : queue) {
            System.out.println(e);
        }

        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.enqueue("dd");
        System.out.println("============");
        for (String e : queue) {
            System.out.println(e);
        }
    }
}
