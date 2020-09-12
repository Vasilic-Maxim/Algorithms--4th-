package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.GeneralizedArrayQueue;
import utils.GeneralizedListQueue;

public class Exercise_38 {
    public static void main(String[] args) {
        GeneralizedListQueue<Integer> listQueue = new GeneralizedListQueue<>();
        GeneralizedArrayQueue<Integer> arrayQueue = new GeneralizedArrayQueue<>();

        int n = 5;
        for (int i = 0; i < n; i++) {
            int item = StdRandom.uniform(100);
            listQueue.insert(item);
            arrayQueue.insert(item);
        }

        for (; n > 0; n--) {
            int index = StdRandom.uniform(n);
            StdOut.printf("Linked List: %s%n", listQueue);
            StdOut.printf("Array:       %s%n", arrayQueue);
            StdOut.printf("Index = %s%n", index);
            StdOut.printf("Deleted (Linked List): %s%n", listQueue.delete(index));
            StdOut.printf("Deleted (Array):       %s%n", arrayQueue.delete(index));
            StdOut.println("=======================================");
        }
    }
}
