package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_30 {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < 10; i++)
            linkedList.addLast(StdRandom.uniform(100));

        StdOut.println(linkedList);
        linkedList.reverse();
        StdOut.println(linkedList);
    }

    static class LinkedList<Item> {
        private Node<Item> head, tail;
        private int size = 0;

        public void addLast(Item first) {
            Node<Item> node = new Node<>(first);
            if (size == 0) head = node;
            else tail.next = node;

            tail = node;
            size++;
        }

        public Item deleteFirst() {
            Item item = head.value;
            head = head.next;
            return item;
        }

        public void reverse() {
            Node<Item> pointer = head;
            head = null;
            for (int i = 0; i < size; i++) {
                Node<Item> tmp = pointer;
                pointer = pointer.next;
                tmp.next = head;
                head = tmp;
            }
        }

        @Override
        public String toString() {
            if (size == 0) return "";

            StringBuilder sb = new StringBuilder();
            Node<Item> pointer = head;

            while (pointer != null) {
                if (sb.length() > 0) sb.append(" -> ");
                sb.append(pointer.value);
                pointer = pointer.next;
            }

            return sb.toString();
        }

        static class Node<Item> {
            private final Item value;
            private Node<Item> next = null;

            public Node(Item value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return value.toString();
            }
        }
    }
}
