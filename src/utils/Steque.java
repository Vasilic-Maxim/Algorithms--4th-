package utils;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class Steque<T> {
    DoublyLinkedList<T> collection = new DoublyLinkedList<>();
    private int size = 0;

    /**
     * @return number of elements in the collection.
     */
    public int size() {
        return size;
    }

    /**
     * @return {@code true} if the collection is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * See {@link DoublyLinkedList#addLast} for details.
     *
     * @param item that will be inserted at the end of the list.
     */
    public void push(T item) {
        collection.addLast(item);
        size++;
    }

    /**
     * See {@link DoublyLinkedList#addFirst} for details.
     *
     * @param item to be inserted at the beginning of the list.
     */
    public void enqueue(T item) {
        collection.addFirst(item);
        size++;
    }

    /**
     * See {@link DoublyLinkedList#removeLast} for details.
     *
     * @return last item from the collection.
     * @throws NoSuchElementException see {@link #checkLength()}
     */
    public T pop() {
        checkLength();
        size--;
        return collection.removeLast();
    }

    /**
     * @throws NoSuchElementException if the collection is empty.
     */
    private void checkLength() {
        if (isEmpty()) throw new NoSuchElementException("The collection is empty.");
    }

    @Override
    public String toString() {
        T[] items = (T[]) new Object[size];
        int i = size - 1;

        for (T item : collection) items[i--] = item;

        StringBuilder sb = new StringBuilder();
        for (T item : items) {
            if (sb.length() > 0) sb.append(" ");
            sb.append(item);
        }
        return sb.toString();
    }
}
