package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_29 {
    /**
     * @see #insert(int[], int, int, int)
     */
    private static int insert(int[] arr, int key) {
        return insert(arr, key, 0, arr.length);
    }

    /**
     * @see #insert(int[], int, int, int)
     */
    private static int insert(int[] arr, int key, int lo) {
        return insert(arr, key, lo, arr.length);
    }

    /**
     * Return the position of the first occurrence of the
     * element in a sorted array. If the element is not
     * present in the array, then it returns its right
     * spot for insertion.
     *
     * @param arr sorted Integer array
     * @param key element we are looking for
     * @param lo  lower bound of the searching range
     * @param hi  upper bound of the searching range
     * @return position where a key should be inserted
     */
    private static int insert(int[] arr, int key, int lo, int hi) {
        if (key > arr[arr.length - 1]) return 0;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (key > arr[mid]) lo = mid + 1;
            else hi = mid;
        }

        return hi;
    }

    public static int rank(int[] arr, int key) {
        int index = insert(arr, key);
        if (arr[index] == key) return index;
        return 0;
    }

    public static int count(int[] arr, int key) {
        int first = insert(arr, key);
        if (arr[first] != key) return 0;

        int second = insert(arr, key + 1, first + 1);
        return second - first;
    }

    public static void main(String[] args) {
        int len = 10;
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) arr[i] = StdRandom.uniform(len / 2);
        Arrays.sort(arr);

        StdOut.printf("Initial array: %s%n", Arrays.toString(arr));

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            StdOut.printf("The number of elements that are smaller than the key: %d%n", rank(arr, key));
            StdOut.printf("The number of elements equal to the key: %d%n", count(arr, key));
        }
    }
}
