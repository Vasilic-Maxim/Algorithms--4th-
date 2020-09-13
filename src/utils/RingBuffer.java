package utils;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class RingBuffer<T> {
    private final T[] collection;
    private final int capacity;
    private int first = 0, last = 0, size = 0;

    public RingBuffer(int capacity) {
        this.capacity = capacity;
        this.collection = (T[]) new Object[capacity];
    }

    /**
     * Adds an item into buffer.
     *
     * @param item to be added to buffer.
     * @throws IllegalStateException see {@link #capacityOverflow()}
     */
    public void enqueue(T item) {
        capacityOverflow();
        collection[last++] = item;
        if (last == capacity) last = 0;
        size++;
    }

    /**
     * @return oldest item in the buffer.
     * @throws NoSuchElementException see {@link #emptyCollection()}
     */
    public T dequeue() {
        emptyCollection();

        T item = collection[first++];
        if (first == capacity) first = 0;
        size--;
        return item;
    }

    /**
     * @return oldest item in the buffer (without incrementing the pointer).
     */
    public T peek() {
        return collection[first];
    }

    /**
     * @throws NoSuchElementException if trying to read data from empty buffer.
     */
    private void emptyCollection() {
        if (isEmpty()) throw new NoSuchElementException("The buffer is empty.");
    }

    /**
     * @throws IllegalStateException if client ties to add an item in
     *                               collection that reached its capacity.
     */
    private void capacityOverflow() {
        if (isFull()) throw new IllegalStateException("Capacity overflow.");
    }

    /**
     * @return {@code true} if the buffer is empty, {@code false} otherwise.
     */
    private boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return {@code true} if buffer is full, {@code false} otherwise.
     */
    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = first, count = 0; count < size; i++, count++) {
            if (i == capacity) i = 0;
            if (i != first) sb.append(" -> ");
            sb.append(collection[i]);
        }

        return sb.toString();
    }
}
