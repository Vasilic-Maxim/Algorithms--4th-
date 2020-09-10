package utils;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<T> implements Iterable<T> {
    private final DoublyNode<T> dummyNode = new DoublyNode<>(null);
    private int size = 0;

    {
        connect(dummyNode, dummyNode);
    }

    /**
     * @return the size of the Linked List.
     */
    public int size() {
        return size;
    }

    /**
     * @return {@code true} if list is empty.
     * {@code false} otherwise.}
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Add a new element in the front of the Linked List.
     *
     * @param item that will be inserted in the
     *             beginning of the Linked List.
     */
    public void addFirst(T item) {
        DoublyNode<T> node = new DoublyNode<>(item);
        connect(node, dummyNode.next);
        connect(dummyNode, node);
        size++;
    }

    /**
     * Add a new element in the end of the Linked List.
     *
     * @param item that will be inserted in the
     *             end of the Linked List.
     */
    public void addLast(T item) {
        DoublyNode<T> node = new DoublyNode<>(item);
        connect(dummyNode.prev, node);
        connect(node, dummyNode);
        size++;
    }

    /**
     * Removes the first element in the Linked List.
     *
     * @return the value of the first element.
     * @throws IllegalStateException if Linked List is empty.
     */
    public T removeFirst() {
        checkSize();

        DoublyNode<T> node = dummyNode.next;
        connect(dummyNode, node.next);
        size--;
        return node.item;
    }

    /**
     * Removes the last element in the Linked List.
     *
     * @return the value of the last element.
     * @throws IllegalStateException if Linked List is empty.
     */
    public T removeLast() {
        checkSize();

        DoublyNode<T> node = dummyNode.prev;
        connect(node.prev, dummyNode);
        size--;
        return node.item;
    }

    /**
     * Removes an element in the Linked List.
     *
     * @return the value of removed element.
     */
    public T remove(int index) {
        checkSize();

        DoublyNode<T> wanted = find(index);
        connect(wanted.prev, wanted.next);
        size--;
        return wanted.item;
    }

    /**
     * Inserts an item before element with the specified index.
     *
     * @param index value of the element before which the element will be inserted.
     * @param item  value of the new element.
     * @throws IndexOutOfBoundsException if index is not member of the range (0, size].
     */
    public void insertBefore(int index, T item) {
        DoublyNode<T> wanted = find(index);
        DoublyNode<T> node = new DoublyNode<>(item);
        connect(wanted.prev, node);
        connect(node, wanted);
        size++;
    }

    /**
     * Inserts an item after element with the specified index.
     *
     * @param index value of the element before which the element will be inserted.
     * @param item  value of the new element.
     * @throws IndexOutOfBoundsException if index is not member of the range (0, size].
     */
    public void insertAfter(int index, T item) {
        DoublyNode<T> wanted = find(index);
        DoublyNode<T> node = new DoublyNode<>(item);
        connect(node, wanted.next);
        connect(wanted, node);
        size++;
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
        DoublyNode<T> pointer = dummyNode.next;
        while (pointer != dummyNode) {
            if (sb.length() > 0) sb.append(" -> ");
            sb.append(pointer.item);
            pointer = pointer.next;
        }

        return sb.toString();
    }

    /**
     * Searches for element at the given index.
     *
     * @param index of the element to search for.
     * @return node at specified index.
     * @throws IndexOutOfBoundsException if index is not member of the range (0, size].
     */
    private DoublyNode<T> find(int index) {
        outOfBounds(index);

        DoublyNode<T> pointer = dummyNode;
        for (int i = 0; i <= index; i++)
            pointer = pointer.next;

        return pointer;
    }

    /**
     * Connects two nodes in the specified order.
     *
     * @param left  node.
     * @param right node.
     */
    private void connect(DoublyNode<T> left, DoublyNode<T> right) {
        left.next = right;
        right.prev = left;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new DoublyLinkedListIterator();
    }

    /**
     * @param index of the element.
     * @throws IndexOutOfBoundsException if index is not member of the range (0, size].
     */
    private void outOfBounds(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("There is no such index in the list.");
    }

    /**
     * @throws IllegalStateException if Linked List is empty.
     */
    private void checkSize() {
        if (isEmpty()) throw new IllegalStateException("The list is empty.");
    }

    public static class DoublyNode<T> {
        private final T item;
        private DoublyNode<T> prev, next;

        public DoublyNode(T item) {
            this.item = item;
        }
    }

    private class DoublyLinkedListIterator implements Iterator<T> {
        private DoublyNode<T> pointer = dummyNode;

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return pointer.next != dummyNode;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            pointer = pointer.next;
            return pointer.item;
        }
    }
}
