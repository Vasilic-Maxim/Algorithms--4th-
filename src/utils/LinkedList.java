package utils;

import java.util.NoSuchElementException;

public class LinkedList<E> {
    private final Node<E> dummyRoot = new Node<>(null);
    private int size = 0;

    public void addFirst(E first) {
        Node<E> tmp = dummyRoot.next;
        dummyRoot.next = new Node<>(first);
        dummyRoot.next.next = tmp;
        size++;
    }

    public E delete(int k) {
        if (k > size)
            throw new NoSuchElementException("Cannot process deletion on an element that does not exist.");

        Node<E> pointer = dummyRoot;
        for (int i = 1; i < k; i++)
            pointer = pointer.next;

        Node<E> nextNode = pointer.next;
        pointer.next = pointer.next.next;
        size--;
        return nextNode.value;
    }

    public E deleteLast() {
        if (size == 0)
            throw new NoSuchElementException("Cannot process deletion on an empty list.");

        Node<E> pointer = dummyRoot;
        while (pointer.next != null && pointer.next.next != null)
            pointer = pointer.next;

        Node<E> nextNode = pointer.next;
        pointer.next = null;
        size--;
        return nextNode.value;
    }

    @Override
    public String toString() {
        if (size == 0) return "";

        StringBuilder sb = new StringBuilder();
        Node<E> pointer = dummyRoot.next;

        while (pointer != null) {
            if (sb.length() > 0) sb.append(" -> ");
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
