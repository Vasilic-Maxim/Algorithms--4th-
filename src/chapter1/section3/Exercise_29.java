package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.CircularQueue;

public class Exercise_29 {
    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        StdOut.println(queue);
        StdOut.printf("Deleted: %d%n", queue.dequeue());
        StdOut.printf("Deleted: %d%n", queue.dequeue());
        StdOut.println(queue);
    }
}
