package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.RandomQueue;

public class Exercise_35 {
    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        StdOut.printf("Original order: %s%n", randomQueue);
        StdOut.printf("Sample #1: %s%n", randomQueue.sample());
        StdOut.printf("Sample #2: %s%n", randomQueue.sample());
        StdOut.printf("Sample #3: %s%n", randomQueue.sample());
        StdOut.printf("Original order: %s%n", randomQueue);
        StdOut.printf("Sample #1: %s%n", randomQueue.dequeue());
        StdOut.printf("Sample #2: %s%n", randomQueue.dequeue());
        StdOut.printf("Sample #3: %s%n", randomQueue.dequeue());
    }
}
