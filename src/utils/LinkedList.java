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
        removeAfter(pointer);
        return nextNode.value;
    }

    public E deleteLast() {
        if (size == 0)
            throw new NoSuchElementException("Cannot process deletion on an empty list.");

        Node<E> pointer = dummyRoot;
        while (pointer.next != null && pointer.next.next != null)
            pointer = pointer.next;

        Node<E> nextNode = pointer.next;
        removeAfter(pointer);
        return nextNode.value;
    }

    public void remove(E key) {
        if (size == 0) return;

        Node<E> pointer = dummyRoot;
        while (pointer.next != null) {
            if (pointer.next.value == key) removeAfter(pointer);
            else pointer = pointer.next;
        }
    }

    private void removeAfter(Node<E> node) {
        if (node == null) return;
        if (node.next == null) return;
        node.next = node.next.next;
        size--;
    }

    private void insertAfter(Node<E> current, Node<E> inserted) {
        if (current == null) return;
        if (inserted == null) return;
        inserted.next = current.next;
        current.next = inserted;
    }

    public boolean find(E value) {
        Node<E> pointer = dummyRoot.next;
        while (pointer != null) {
            if (pointer.value == value) return true;
            pointer = pointer.next;
        }

        return false;
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
