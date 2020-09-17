package utils;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0, pushes = 0, pops = 0;

    /**
     * @return the size of the stack.
     */
    public int size() {
        return size;
    }

    /**
     * @return {@code true} if stack is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param item to be inserted into the stack.
     */
    public void push(T item) {
        head = new Node<>(item, head);
        pushes++;
        size++;
    }

    /**
     * Removes the last inserted element and returns its value.
     *
     * @return value of deleted element.
     */
    public T pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");

        T item = head.item;
        head = head.next;

        pops++;
        size--;

        return item;
    }

    /**
     * @return first to pop element (without removing).
     */
    public T peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return head.item;
    }

    /**
     * @return string representation of the stack.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (T item : this) {
            s.append(item);
            s.append(' ');
        }
        return s.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private static class Node<T> {
        private final T item;
        private final Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }

    private class StackIterator implements Iterator<T> {
        private final int pushesReg = pushes;
        private final int popsReg = pops;
        private Node<T> current = head;

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
         * @throws NoSuchElementException          if the iteration has no more elements
         * @throws ConcurrentModificationException if the number of pop and push
         *                                         operations changed during the iteration.
         */
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No elements to iterate through.");
            if (pushesReg != pushes) throw new ConcurrentModificationException("Stack was modified.");
            if (popsReg != pops) throw new ConcurrentModificationException("Stack was modified.");

            T item = current.item;
            current = current.next;

            return item;
        }
    }
}
