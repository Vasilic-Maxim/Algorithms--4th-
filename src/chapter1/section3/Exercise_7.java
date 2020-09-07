package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_7 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");
        StdOut.printf("Last element in the stack: %s", stack.peek());
    }

    public static class Stack<Item> {
        private Node first;
        private int N;

        public boolean isEmpty() {
            return first == null;
        }

        public int size() {
            return N;
        }

        public void push(Item item) {
            Node oldFirst = first;
            first = new Node();
            first.item = item;
            first.next = oldFirst;
            N++;
        }

        public Item pop() {
            Item item = first.item;
            first = first.next;
            N--;
            return item;
        }

        public Item peek() {
            return first.item;
        }

        private class Node {
            Item item;
            Node next;
        }
    }
}
