package utils;

@SuppressWarnings("unchecked")
public class ResizingArrayDeque<T> {
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
    public void pushLeft(T item) {
        if (isLeftFull()) rightShift();
        collection[--start] = item;
        size++;
        if (isFull()) resize(size * 2);
    }

    /**
     * @param item that will be inserted.
     */
    public void pushRight(T item) {
        if (isRightFull()) leftShift();
        collection[end++] = item;
        size++;
        if (isFull()) resize(size * 2);
    }

    /**
     * @return first element of the collection.
     */
    public T popLeft() {
        size--;
        T item = collection[start];
        collection[start++] = null;

        if (isAlmostEmpty()) resize(size * 2);

        return item;
    }

    /**
     * @return last element of the collection.
     */
    public T popRight() {
        --size;
        T item = collection[--end];
        collection[end] = null;

        if (isAlmostEmpty()) resize(size * 2);

        return item;
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
     * Checks where the right side of the collection is full.
     *
     * @return {@code true} if the right side is full, {@code false} otherwise.
     */
    private boolean isRightFull() {
        return end == collection.length;
    }

    /**
     * Checks where the left side of the collection is full.
     *
     * @return {@code true} if the left side is full, {@code false} otherwise.
     */
    private boolean isLeftFull() {
        return start == 0;
    }

    /**
     * Moves all elements one step to the right.
     */
    private void rightShift() {
        System.arraycopy(collection, start, collection, start + 1, size);
        collection[start++] = null;
        end++;
    }

    /**
     * Moves all elements one step to the left.
     */
    private void leftShift() {
        System.arraycopy(collection, start, collection, --start, size);
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
}
