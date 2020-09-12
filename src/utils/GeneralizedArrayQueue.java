package utils;

import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class GeneralizedArrayQueue<T> {
    private T[] collection = (T[]) new Object[1];
    private int start = 0, end = 0, size = 0;

    /**
     * @return {@code true} if collection is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @return the size of the collection.
     */
    public int size() {
        return size;
    }

    /**
     * @param item that will be inserted.
     */
    public void insert(T item) {
        if (isRightFull()) leftShift();
        collection[end++] = item;
        size++;
        if (isFull()) resize(size * 2);
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

        index = start + index;
        T item = collection[index];
        collection[index] = null;

        if (index == start) start++;
        else if (index + 1 == end) end--;
        else leftShift(index);

        size--;
        if (isAlmostEmpty()) resize(size * 2);

        return item;
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
     * Checks where the right side of the collection is full.
     *
     * @return {@code true} if the right side is full, {@code false} otherwise.
     */
    private boolean isRightFull() {
        return end == collection.length;
    }

    /**
     * Moves all elements one step to the left.
     */
    private void leftShift() {
        leftShift(--start);
    }
    private void leftShift(int destPos) {
        int srcPos = destPos + 1;
        System.arraycopy(collection, srcPos, collection, destPos, end - destPos);
        collection[--end] = null;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < end; i++) {
            if (i > start) sb.append(" -> ");
            sb.append(collection[i]);
        }

        return sb.toString();
    }
}
