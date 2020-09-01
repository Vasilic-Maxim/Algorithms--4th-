package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_38 {
    /**
     * @param array  sorted array with random numbers.
     * @param wanted key we are searching for.
     */
    private static void testBruteForceSearch(int[] array, int wanted) {
        long startTime = System.nanoTime();
        int result = BruteForceSearch.rank(wanted, array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        StdOut.printf("It took %dms to run BruteForceSearch. The result: %d%n", duration, result);
    }

    /**
     * @param array  sorted array with random numbers.
     * @param wanted key we are searching for.
     */
    private static void testBinarySearch(int[] array, int wanted) {
        long startTime = System.nanoTime();
        int result = BinarySearch.rank(wanted, array);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;
        StdOut.printf("It took %dms to run BruteForceSearch. The result: %d%n", duration, result);
    }

    public static void main(String[] args) {
        // Lets create a sorted array with size 1M
        int size = 1000000;
        int[] array = new int[size];
        int prev = 0;
        for (int i = 0; i < size; i++) {
            array[i] = prev + StdRandom.uniform(1, 3);
            prev = array[i];
        }

        int wanted = StdRandom.uniform(size + 1);
        StdOut.printf("Wanted: %d%n", wanted);
        testBruteForceSearch(array, wanted);
        testBinarySearch(array, wanted);
    }

    static class BruteForceSearch {
        public static int rank(int key, int[] a) {
            for (int i = 0; i < a.length; i++)
                if (a[i] == key) return i;
            return -1;
        }
    }

    static class BinarySearch {
        public static int rank(int key, int[] a) {
            int lo = 0;
            int hi = a.length - 1;
            while (lo <= hi) {
                int middle = lo + (hi - lo) / 2;
                if (key < a[middle]) hi = middle - 1;
                else if (key > a[middle]) lo = middle + 1;
                else return middle;
            }

            return -1;
        }
    }
}
