package chapter1.section3;


import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_27 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++)
            linkedList.addFirst(StdRandom.uniform(100));

        StdOut.println(linkedList);
        StdOut.println(linkedList.max());
    }

    static class LinkedList {
        private final Node dummyRoot = new Node(-1);
        private int size = 0;

        public void addFirst(Integer first) {
            Node tmp = dummyRoot.next;
            dummyRoot.next = new Node(first);
            dummyRoot.next.next = tmp;
            size++;
        }

        public int max() {
            return max(dummyRoot.next);
        }

        private int max(Node node) {
            if (size == 0) return 0;
            int maxValue = 0;
            while (node != null) {
                maxValue = Math.max(maxValue, node.value);
                node = node.next;
            }

            return maxValue;
        }

        @Override
        public String toString() {
            if (size == 0) return "";

            StringBuilder sb = new StringBuilder();
            Node pointer = dummyRoot.next;

            while (pointer != null) {
                if (sb.length() > 0) sb.append(" -> ");
                sb.append(pointer.value);
                pointer = pointer.next;
            }

            return sb.toString();
        }

        static class Node {
            private final int value;
            private Node next = null;

            public Node(int value) {
                this.value = value;
            }

            @Override
            public String toString() {
                return Integer.toString(value);
            }
        }
    }
}
