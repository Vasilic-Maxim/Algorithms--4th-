package utils;

public class Deque<T> {
    private final DoublyLinkedList<T> collection = new DoublyLinkedList<>();

    /**
     * See {@link DoublyLinkedList#isEmpty()} for details.
     *
     * @return {@code true} if collection is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return collection.isEmpty();
    }

    /**
     * See {@link DoublyLinkedList#size()} for more details.
     *
     * @return the size of the collection.
     */
    public int size() {
        return collection.size();
    }

    /**
     * See {@link DoublyLinkedList#addFirst} for details.
     *
     * @param item that will be inserted.
     */
    public void pushLeft(T item) {
        collection.addFirst(item);
    }

    /**
     * See {@link DoublyLinkedList#addLast} for details.
     *
     * @param item that will be inserted.
     */
    public void pushRight(T item) {
        collection.addLast(item);
    }

    /**
     * See {@link DoublyLinkedList#removeFirst} for details.
     *
     * @return first element of the collection.
     */
    public T popLeft() {
        return collection.removeFirst();
    }

    /**
     * See {@link DoublyLinkedList#removeLast} for details.
     *
     * @return last element of the collection.
     */
    public T popRight() {
        return collection.removeLast();
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
