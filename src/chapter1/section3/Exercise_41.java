package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_41 {
    public static void main(String[] args) {
        Queue<Integer> initial = new Queue<>();
        Queue<Integer> clone = new Queue<>();
        int n = StdRandom.uniform(5, 10);

        for (int i = 0; i < n; i++)
            initial.enqueue(StdRandom.uniform(10));

        for (int i = 0; i < n; i++) {
            int item = initial.dequeue();
            initial.enqueue(item);
            clone.enqueue(item);
        }

        StdOut.printf("Initial: %s%n", initial);
        StdOut.printf("Clone:   %s%n", clone);
    }
}
