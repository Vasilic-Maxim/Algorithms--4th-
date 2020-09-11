package utils;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class RandomBag<T> implements Iterable<T> {
    private T[] collection = (T[]) new Object[1];
    private int size = 0;

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
     * Adds an item into bag.
     *
     * @param item to be added.
     */
    public void add(T item) {
        collection[size++] = item;
        if (size == collection.length) resize();
    }

    /**
     * Replaces the collection with the new resized one.
     */
    private void resize() {
        T[] resized = (T[]) new Object[size * 2];
        System.arraycopy(collection, 0, resized, 0, size);
        collection = resized;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i > 0) sb.append(" -> ");
            sb.append(collection[i]);
        }

        return sb.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<T> iterator() {
        return new BagIterator();
    }

    /**
     * Iterates over elements of type {@code T} in random order.
     */
    class BagIterator implements Iterator<T> {
        private final T[] iterable = (T[]) new Object[size];
        private int index = -1;

        public BagIterator() {
            System.arraycopy(collection, 0, iterable, 0, size);
            StdRandom.shuffle(iterable);
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            return index < iterable.length - 1;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public T next() {
            if (!hasNext()) throw new NoSuchElementException("No elements to iterate.");
            return iterable[++index];
        }
    }
}
