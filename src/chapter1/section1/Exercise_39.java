package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_39 {
    /**
     * @param size size of the randomly generated arrays.
     * @return number of common elements for both arrays.
     */
    private static int experiment(int size) {
        int[] array1 = generate(size);
        int[] array2 = generate(size);

        Arrays.sort(array2);

        int commonElements = 0;
        for (int i = 0; i < size; i++) {
            if (contains(array2, array1[i]))
                commonElements++;
        }

        return commonElements;
    }

    /**
     * @param size size of the array.
     * @return randomly generated array.
     */
    private static int[] generate(int size) {
        int[] result = new int[size];
        for (int i = 0; i < size; i++)
            result[i] = StdRandom.uniform(100000, 1000000);
        return result;
    }

    /**
     * @param array what contains six-digit numbers.
     * @param key   element we are searching for.
     * @return true if key exists in the array. Otherwise false.
     */
    private static boolean contains(int[] array, int key) {
        int lo = 0;
        int hi = array.length - 1;
        while (lo <= hi) {
            int middle = lo + (hi - lo) / 2;
            if (key < array[middle]) hi = middle - 1;
            else if (key > array[middle]) lo = middle + 1;
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        int t = StdRandom.uniform(3, 10);
        int[] results = new int[4];
        for (int i = 0; i < t; i++) {
            results[0] += experiment(10000);
            results[1] += experiment(100000);
            results[2] += experiment(1000000);
            results[3] += experiment(10000000);
        }

        StdOut.printf("%8s   %s%n", "N", "AVG");
        StdOut.printf("%8d   %.2f%n", 10000, ((double) results[0]) / t);
        StdOut.printf("%8d   %.2f%n", 100000, ((double) results[1]) / t);
        StdOut.printf("%8d   %.2f%n", 1000000, ((double) results[2]) / t);
        StdOut.printf("%8d   %.2f%n", 10000000, ((double) results[3]) / t);
    }
}
