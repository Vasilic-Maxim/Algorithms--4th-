package chapter1.section2;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_9 {
    public static void main(String[] args) {
        int n = StdRandom.uniform(10, 20);
        int[] numbers = generate(n);
        int key = StdRandom.uniform(60);
        Counter counter = new Counter("Calls");
        int index = rank(numbers, key, counter);

        StdOut.printf("Initial array: %s%n", Arrays.toString(numbers));
        if (index >= 0) StdOut.printf("Key '%d' was found at the index %d%n", key, index);
        else StdOut.printf("Key '%d' was not found%n", key);
        StdOut.printf("Number of keys being examined: %d", counter.tally());
    }

    /**
     * @param n length of the array.
     * @return a sorted array of random numbers.
     */
    private static int[] generate(int n) {
        int[] result = new int[n];
        int prev = 0;
        for (int i = 0; i < n; i++) {
            result[i] = StdRandom.uniform(prev, prev + 3);
            prev = result[i] + 1;
        }

        return result;
    }

    /**
     * @param array   array of numbers.
     * @param key     value we are searching for.
     * @param counter number of keys being examined.
     * @return index of the key in the array.
     */
    private static int rank(int[] array, int key, Counter counter) {
        int lo = 0, hi = array.length - 1;
        while (lo <= hi) {
            counter.increment();
            int middle = lo + (hi - lo) / 2;
            if (key < array[middle]) hi = middle - 1;
            else if (key > array[middle]) lo = middle + 1;
            else return middle;
        }

        return -1;
    }
}
