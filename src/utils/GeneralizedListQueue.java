package utils;

import java.util.NoSuchElementException;

public class GeneralizedListQueue<T> {
    private final Node<T> dummyNode = new Node<>(null);
    private Node<T> last;
    private int size = 0;

    /**
     * @return {@code true} if the queue is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Insert an item into the queue.
     *
     * @param item to be inserted.
     */
    public void insert(T item) {
        Node<T> node = new Node<>(item);
        if (size == 0) dummyNode.next = node;
        else last.next = node;
        last = node;
        size++;
    }

    /**
     * Delete an item from the queue at a specified index.
     *
     * @param index of the item to be deleted.
     * @return value of the deleted item.
     */
    public T delete(int index) {
        checkSize();
        outOfBounds(index);

        Node<T> pointer = dummyNode;
        for (; index > 0; index--)
            pointer = pointer.next;

        T item = pointer.next.item;
        pointer.next = pointer.next.next;

        if (pointer.next == null) last = pointer;

        size--;
        return item;
    }

    /**
     * @throws IllegalStateException if Linked List is empty.
     */
    private void checkSize() {
        if (isEmpty()) throw new NoSuchElementException("The queue is empty.");
    }

    /**
     * @param index of the element.
     * @throws IndexOutOfBoundsException if index is not member of the range (0, size].
     */
    private void outOfBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Invalid index.");
    }

    /**
     * Return a String representation of the
     * Doubly Linked List.
     *
     * @return string representation of the list.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> pointer = dummyNode.next;
        for (int i = 0; i < size; i++) {
            if (sb.length() > 0) sb.append(" -> ");
            sb.append(pointer.item);
            pointer = pointer.next;
        }

        return sb.toString();
    }

    static class Node<T> {
        private final T item;
        private Node<T> next = null;

        public Node(T item) {
            this.item = item;
        }
    }
}
