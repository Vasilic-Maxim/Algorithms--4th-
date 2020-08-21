package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise_28 {
    /**
     * This method searches for position to insert the key.
     * It defers from the searching version.
     *
     * @param a   initial array
     * @param key value for that we a searching right spot
     * @param lo  starting left point
     * @return right spot to insert
     */
    public static int insert(int[] a, int key, int lo) {
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return lo;
    }

    public static void main(String[] args) {
        int len = 20;
        int[] whitelist = new int[len];
        for (int i = 0; i < len; i++) whitelist[i] = StdRandom.uniform(len / 2);
        Arrays.sort(whitelist);

        StdOut.printf("Whitelist: %s%n", Arrays.toString(whitelist));

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < len; ) {
            result.add(whitelist[i]);
            i = insert(whitelist, whitelist[i] + 1, i + 1);
        }

        StdOut.printf("Edited: %s%n", result.toString());
    }
}
