package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_19 {
    private static ListNode<String> deleteLast(ListNode<String> first) {
        if (first == null) return null;
        if (first.next == null) return null;

        ListNode<String> node = first;
        while (node.next != null && node.next.next != null)
            node = node.next;

        node.next = null;
        return first;
    }

    private static void toString(ListNode<String> node) {
        while (node != null) {
            StdOut.print(node);
            node = node.next;
        }
        StdOut.println();
    }

    public static void main(String[] args) {
        ListNode<String> first = new ListNode<>("Hello");
        ListNode<String> second = new ListNode<>("world");
        ListNode<String> third = new ListNode<>("!");
        first.next = second;
        second.next = third;

        toString(first);
        first = deleteLast(first);
        toString(first);
    }

    public static class ListNode<Item> {
        private final Item value;
        private ListNode<Item> next = null;

        public ListNode(Item value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s %s", value, (next != null ? " -> " : ""));
        }
    }
}
