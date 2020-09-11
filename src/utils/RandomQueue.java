package utils;

import edu.princeton.cs.algs4.StdRandom;

@SuppressWarnings("unchecked")
public class RandomQueue<T> {
    private T[] collection = (T[]) new Object[1];
    private int start = 0, end = 0, size = 0;

    /**
     * @return {@code true} if collection is empty, {@code false} otherwise.}
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return number of elements in collection.
     */
    public int size() {
        return size;
    }

    /**
     * @param item that will be inserted.
     */
    public void enqueue(T item) {
        collection[end++] = item;
        size++;
        if (isFull()) resize(size * 2);
    }

    /**
     * @return first element of the collection.
     */
    public T dequeue() {
        int randomIndex = StdRandom.uniform(start, end);
        T item = collection[randomIndex];
        collection[randomIndex] = collection[--end];
        collection[end] = null;
        size--;

        if (isAlmostEmpty()) resize(size * 2);

        return item;
    }

    /**
     * return a random item, but do not remove.
     *
     * @return random item.
     */
    public T sample() {
        int randomIndex = StdRandom.uniform(start, end);
        return collection[randomIndex];
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (i > start) sb.append(" -> ");
            sb.append(collection[i]);
        }

        return sb.toString();
    }

    /**
     * Checks where the collection is empty.
     *
     * @return {@code true} if the collection is empty, {@code false} otherwise.
     */
    private boolean isAlmostEmpty() {
        return size != 0 && size * 4 == collection.length;
    }

    /**
     * Checks where the collection is full.
     *
     * @return {@code true} if the collection is full, {@code false} otherwise.
     */
    private boolean isFull() {
        return size == collection.length;
    }

    /**
     * Replaces the collection with the new resized one.
     *
     * @param newSize size of the new collection.
     */
    private void resize(int newSize) {
        T[] resized = (T[]) new Object[newSize];
        System.arraycopy(collection, start, resized, 0, size);
        collection = resized;
        start = 0;
        end = start + size;
    }
}
