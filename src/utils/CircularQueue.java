package utils;

import java.util.NoSuchElementException;

public class CircularQueue<E> {
    private Node<E> first, last;
    private int size = 0;

    public void enqueue(E item) {
        Node<E> node = new Node<>(item);
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

    public E dequeue() {
        if (size == 0) throw new NoSuchElementException("The queue is empty.");

        E item = first.value;
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
        Node<E> pointer = first;
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
