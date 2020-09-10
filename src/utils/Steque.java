package utils;

public class Steque<T> {
    DoublyLinkedList<T> collection = new DoublyLinkedList<>();

    /**
     * See {@link DoublyLinkedList#addLast} for details.
     *
     * @param item that will be inserted at the end of the list.
     */
    public void push(T item) {
        collection.addLast(item);
    }

    /**
     * See {@link DoublyLinkedList#addFirst} for details.
     *
     * @param item to be inserted at the beginning of the list.
     */
    public void enqueue(T item) {
        collection.addFirst(item);
    }

    /**
     * See {@link DoublyLinkedList#removeLast} for details.
     *
     * @return last item from the collection.
     */
    public T pop() {
        return collection.removeLast();
    }

    @Override
    public String toString() {
        return collection.toString();
    }
}
