package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_15 {
    public static int[] generate(int length, int bound) {
        // Create an array of random numbers.
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            result[i] = StdRandom.uniform(bound);
        }

        return result;
    }

    public static int[] histogram(int[] initial, int m) {
        // Place in result-array only values that are lower than m
        // (length of the array). Otherwise, you will get an exception!
        int[] result = new int[m];
        for (int num : initial) {
            if (num < m) result[num]++;
        }

        return result;
    }

    public static void main(String[] args) {
        int length = 10, m = 7;
        int[] initial = generate(length, m);
        int[] histogram = histogram(initial, m);
        int sum = Arrays.stream(histogram).sum();
        StdOut.printf("Initial array: %s%n", Arrays.toString(initial));
        StdOut.printf("Histogram array: %s%n", Arrays.toString(histogram));
        StdOut.printf("Length of initial array: %d%n", length);
        StdOut.printf("Sum of items int the result-array: %d%n", sum);
        StdOut.printf("Length of initial array equal to sum of items in result-array: %b", length == sum);
    }
}
