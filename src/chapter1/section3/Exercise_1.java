package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_1 {
    public static void main(String[] args) {
        FixedCapacityStackOfStrings stack = new FixedCapacityStackOfStrings(5);
        stack.push("Hello");
        stack.push("World");
        stack.push(".");

        StdOut.printf("Is empty: %b%n", stack.isEmpty());
        StdOut.printf("Size: %d%n", stack.size());
        StdOut.printf("Is full: %b%n", stack.isFull());
    }

    public static class FixedCapacityStackOfStrings {
        private final String[] a;
        private int N;

        public FixedCapacityStackOfStrings(int cap) {
            a = new String[cap];
        }

        private boolean isEmpty() {
            return N == 0;
        }

        private int size() {
            return N;
        }

        private void push(String item) {
            a[N++] = item;
        }

        private boolean isFull() {
            return N == a.length;
        }

        public String pop() {
            return a[--N];
        }
    }
}
