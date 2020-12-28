package com.jackpan.algorithm;

import org.w3c.dom.Node;

import java.util.Iterator;

/**
 * @author jackpan
 * @version v1.0 2020/12/28 13:02
 */
public class Stack<E> implements Iterable<E>, StackAPI<E> {

    private Node first;

    private int size;

    private class Node {

        private Node next;

        private E item;

        /**
         * Gets next.
         *
         * @return Value of next.
         */
        public Node getNext() {
            return this.next;
        }

        /**
         * Sets next.
         *
         * @param next Simple param.
         */
        public void setNext(Node next) {
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

        private Node(){}

        private Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    private Node newNode(E item, Node next) {
        return new Node(item, next);
    }

    @Override
    public void push(E e) {
        if (this.first == null) {
            this.first = newNode(e, null);
        } else {
            Node oldFirst = this.first;
            this.first = newNode(e, oldFirst);
        }
        size++;
    }

    @Override
    public E peek() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }
        return this.first.getItem();
    }

    @Override
    public E pop() {
        if (isEmpty()) {
            throw new NullPointerException("Stack is empty");
        }
        E e = peek();
        this.first = this.first.next;
        size--;
        return e;
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
        return new ListIterator();
    }


    private class ListIterator implements Iterator<E> {

        private Stack.Node current = first;

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
        Stack<String> stack = new Stack<>();
        stack.push("A");
        stack.push("b");
        stack.push("c");
        System.out.println(stack.peek());
        stack.push("c");
        System.out.println(stack.peek());
        stack.pop();
        System.out.println("========");
        for (String s : stack) {
            System.out.println(s);
        }
        System.out.println(stack.size());
    }

}
