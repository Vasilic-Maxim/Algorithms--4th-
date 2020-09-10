package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.DoublyLinkedList;

public class Exercise_31 {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(3);
        list.insertAfter(0, 4);
        list.insertBefore(0, 2);
        list.addFirst(1);
        list.addLast(5);
        StdOut.printf("List: %s%n", list);
        StdOut.printf("Deleted (first element): %s%n", list.removeFirst());
        StdOut.printf("List: %s%n", list);
        StdOut.printf("Deleted (last element): %s%n", list.removeLast());
        StdOut.printf("List: %s%n", list);
        StdOut.printf("Deleted (at index): %s%n", list.remove(1));
        StdOut.printf("List: %s%n", list);
        StdOut.printf("List size: %d%n", list.size());
    }
}
