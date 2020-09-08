package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_14 {
    public static void main(String[] args) {
        ResizingArrayQueueOfStrings queue = new ResizingArrayQueueOfStrings();
        StdOut.printf("Initial real size: %d%n", queue.realSize());
        queue.enqueue("Hello");
        queue.enqueue("World");
        StdOut.printf("Real size after adding two items: %d%n", queue.realSize());
        StdOut.printf("Extract item: %s%n", queue.dequeue());
        StdOut.printf("Extract item: %s%n", queue.dequeue());
        StdOut.printf("Final real size: %d%n", queue.realSize());
    }

    public static class ResizingArrayQueueOfStrings {
        String[] storage = new String[1];
        int n = 0;

        public ResizingArrayQueueOfStrings() {}

        public int realSize() {
            return storage.length;
        }

        public void enqueue(String value) {
            storage[n++] = value;
            if (n == storage.length) resize(n * 2);
        }

        public String dequeue() {
            String item = storage[--n];
            if (n * 4 == storage.length) resize(n * 2);
            return item;
        }

        private void resize(int size) {
            String[] newStorage = new String[size];
            System.arraycopy(storage, 0, newStorage, 0, n);
            storage = newStorage;
        }
    }
}
