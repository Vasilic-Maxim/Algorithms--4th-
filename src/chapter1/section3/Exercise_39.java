package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.RingBuffer;

public class Exercise_39 {
    public static void main(String[] args) {
        int n = 5;
        RingBuffer<Integer> buffer = new RingBuffer<>(n);

        for (int i = 0; i < n; i++)
            buffer.enqueue(StdRandom.uniform(100));

        StdOut.printf("Initial buffer: %s%n", buffer);
        StdOut.printf("Deleted: %s%n", buffer.dequeue());
        StdOut.printf("Show next to delete: %s%n", buffer.peek());
        buffer.enqueue(StdRandom.uniform(100));
        StdOut.printf("Final buffer: %s%n", buffer);

        for (int i = 0; i <= n; i++)
            StdOut.printf("Deleted: %s%n", buffer.dequeue());
    }
}
