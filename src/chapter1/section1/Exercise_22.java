package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_22 {
    public static int rank(int key, int[] a) {
        return rank(key, a, 0, a.length - 1, 1);
    }

    public static int rank(int key, int[] a, int lo, int hi, int depth) {
        StdOut.printf("%s [lo, hi] = [%d, %d]%n", "*".repeat(depth), lo, hi);
        if (lo > hi) return -1;

        int mid = lo + (hi - lo) / 2;
        if (key < a[mid]) return rank(key, a, lo, mid - 1, depth + 1);
        else if (key > a[mid]) return rank(key, a, mid + 1, hi, depth + 1);
        else return mid;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 4;
        StdOut.printf("Result: %d", rank(target, array));
    }
}
