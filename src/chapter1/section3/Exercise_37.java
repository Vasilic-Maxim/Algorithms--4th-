package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_37 {
    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        int n = StdRandom.uniform(10, 16);
        int m = StdRandom.uniform(2, 6);
        for (int i = 0; i < n; i++) queue.enqueue(i);

        StdOut.printf("n = %d, m = %d%n", n, m);
        StdOut.printf("Initial: %s%n", queue);
        while (!queue.isEmpty() && queue.size() > 1) {
            for (int i = 1; i < m; i++)
                queue.enqueue(queue.dequeue());
            StdOut.printf("[%d] passed away.%n", queue.dequeue());
        }

        StdOut.printf("[%d] is safe position.%n", queue.dequeue());
    }
}
