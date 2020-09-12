package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.RandomQueue;

public class Exercise_36 {
    public static void main(String[] args) {
        RandomQueue<Integer> randomQueue = new RandomQueue<>();
        randomQueue.enqueue(1);
        randomQueue.enqueue(2);
        randomQueue.enqueue(3);
        randomQueue.enqueue(4);
        StdOut.printf("Original order: %s%n", randomQueue);
        StdOut.print("Original order: ");
        for (Integer item : randomQueue) StdOut.printf("%s ", item);
    }
}
