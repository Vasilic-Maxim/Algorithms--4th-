package utils;

import java.util.NoSuchElementException;

public class CircularQueue<T> {
    private Node<T> first, last;
    private int size = 0;

    public void enqueue(T item) {
        Node<T> node = new Node<>(item);
        if (size == 0) {
            first = node;
            last = node;
            last.next = first;
        } else {
            last.next = node;
            last = node;
        }
        size++;
    }

    public T dequeue() {
        if (size == 0) throw new NoSuchElementException("The queue is empty.");

        T item = first.value;
        if (size == 1) {
            first = null;
            last = null;
        } else {
            last.next = first.next;
            first = first.next;
        }

        size--;
        return item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> pointer = first;
        for (int i = 0; i < size; i++) {
            if (i != 0) sb.append(" -> ");
            sb.append(pointer.value);
            pointer = pointer.next;
        }

        return sb.toString();
    }

    public static class Node<E> {
        private final E value;
        private Node<E> next = null;

        public Node(E value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }
}
