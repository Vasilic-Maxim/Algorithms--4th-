package utils;

import java.util.HashMap;

public class MoveToFront<T> {
    private final HashMap<T, DoublyNode<T>> members = new HashMap<>();
    private DoublyNode<T> front = null;
    private int size = 0;

    /**
     * @return size of the queue.
     */
    public int size() {
        return size;
    }

    /**
     * @return {@code true} if the queue is empty,
     * {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Adds an item in front of the queue or if item
     * ia a duplicate moves it to front of the queue.
     *
     * @param item to be inserted.
     */
    public void add(T item) {
        if (members.containsKey(item)) moveToFront(item);
        else addToFront(item);
    }

    /**
     * Adds a new item to the queue.
     *
     * @param item to be inserted.
     */
    private void addToFront(T item) {
        DoublyNode<T> node = new DoublyNode<>(item);
        insertBeforeFront(node);
        members.put(item, node);
        size++;
    }

    /**
     * Moves an existing item in front of the queue.
     *
     * @param item to be moved.
     */
    private void moveToFront(T item) {
        DoublyNode<T> node = members.get(item);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        insertBeforeFront(node);
    }

    /**
     * Inserts a node in front of the queue.
     *
     * @param node to be inserted.
     */
    private void insertBeforeFront(DoublyNode<T> node) {
        if (front != null) {
            node.next = front;
            front.prev = node;
        }
        front = node;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoublyNode<T> pointer = front;
        while (pointer != null) {
            if (sb.length() > 0) sb.append(" -> ");
            sb.append(pointer.item);
            pointer = pointer.next;
        }

        return sb.toString();
    }

    private static class DoublyNode<T> {
        private final T item;
        private DoublyNode<T> prev, next;

        public DoublyNode(T item) {
            this.item = item;
        }
    }
}
