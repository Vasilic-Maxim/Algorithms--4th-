package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.Deque;

import java.util.NoSuchElementException;

public class Exercise_48 {
    public static void main(String[] args) {
        TwoStackDeque<Integer> collection = new TwoStackDeque<>();
        for (int i = 0; i < 5; i++) {
            int item = StdRandom.uniform(100);
            collection.firstPush(item);
            collection.secondPush(item);
        }

        StdOut.printf("Two stacks view: %s%n", collection);

        while (!collection.isFirstEmpty())
            StdOut.printf("Pop item from first stack: %s%n", collection.popFirst());

        while (!collection.isSecondEmpty())
            StdOut.printf("Pop item from second stack: %s%n", collection.popSecond());
    }

    private static class TwoStackDeque<T> {
        private final Deque<T> collection = new Deque<>();
        private static int firstSize = 0;
        private static int secondSize = 0;

        /**
         * @return {@code true} if first stack is empty, {@code false} otherwise.
         */
        private boolean isFirstEmpty() {
            return firstSize == 0;
        }

        /**
         * @return {@code true} if second stack is empty, {@code false} otherwise.
         */
        private boolean isSecondEmpty() {
            return secondSize == 0;
        }

        /**
         * Pushes an item in the first stack.
         *
         * @param item to be pushed in first stack.
         */
        private void firstPush(T item) {
            collection.pushLeft(item);
            firstSize++;
        }

        /**
         * Pushes an item in the second stack.
         *
         * @param item to be pushed in second stack.
         */
        private void secondPush(T item) {
            collection.pushRight(item);
            secondSize++;
        }

        /**
         * @return a recently inserted item in first stack.
         */
        private T popFirst() {
            checkSize(firstSize);
            firstSize--;
            return collection.popLeft();
        }

        /**
         * @return a recently inserted item in second stack.
         */
        private T popSecond() {
            checkSize(secondSize);
            secondSize--;
            return collection.popRight();
        }

        /**
         * @param size number of items in collection.
         */
        private void checkSize(int size) {
            if (size == 0) throw new NoSuchElementException("The collection is empty.");
        }

        @Override
        public String toString() {
            return collection.toString();
        }
    }
}
