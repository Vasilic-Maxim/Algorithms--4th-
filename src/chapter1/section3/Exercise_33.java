package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.Deque;
import utils.ResizingArrayDeque;

public class Exercise_33 {
    public static void main(String[] args) {
        testDeque();
        testResizedArrayDeque();
    }

    private static void testDeque() {
        StdOut.println("=== Deque test ===");

        Deque<Integer> deque = new Deque<>();
        deque.pushRight(3);
        deque.pushLeft(2);
        deque.pushRight(4);
        deque.pushLeft(1);
        deque.pushLeft(0);
        StdOut.printf("List: %s%n", deque);
        StdOut.printf("Removed item (first): %s%n", deque.popLeft());
        StdOut.printf("Removed item (first): %s%n", deque.popLeft());
        StdOut.printf("Removed item (last): %s%n", deque.popRight());
        StdOut.printf("Removed item (last): %s%n", deque.popRight());
        StdOut.printf("List: %s%n", deque);
        StdOut.printf("Length: %d%n", deque.size());
        StdOut.printf("Is empty: %b%n", deque.isEmpty());

        StdOut.println();
    }

    private static void testResizedArrayDeque() {
        StdOut.println("=== ResizedArrayDeque test ===");

        ResizingArrayDeque<Integer> deque = new ResizingArrayDeque<>();
        deque.pushRight(3);
        deque.pushLeft(2);
        deque.pushRight(4);
        deque.pushLeft(1);
        deque.pushLeft(0);
        StdOut.printf("List: %s%n", deque);
        StdOut.printf("Removed item (first): %s%n", deque.popLeft());
        StdOut.printf("Removed item (first): %s%n", deque.popLeft());
        StdOut.printf("Removed item (last): %s%n", deque.popRight());
        StdOut.printf("Removed item (last): %s%n", deque.popRight());
        StdOut.printf("List: %s%n", deque);
        StdOut.printf("Length: %d%n", deque.size());
        StdOut.printf("Is empty: %b%n", deque.isEmpty());

        StdOut.println();
    }
}
