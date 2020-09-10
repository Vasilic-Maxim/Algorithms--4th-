package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.Steque;

public class Exercise_32 {
    public static void main(String[] args) {
        Steque<Integer> queue = new Steque<>();
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.enqueue(2);
        queue.enqueue(1);
        StdOut.printf("List: %s%n", queue);
        StdOut.printf("Removed item (last): %s%n", queue.pop());
        StdOut.printf("List: %s%n", queue);
    }
}
