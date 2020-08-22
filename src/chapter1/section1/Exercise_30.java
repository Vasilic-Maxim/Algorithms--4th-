package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_30 {
    /**
     * @param p positive Integer value
     * @param q positive Integer value
     * @return greatest common divider
     */
    private static int gcd(int p, int q) {
        if (p == 0) return q;
        if (q == 0) return p;
        return gcd(q, p % q);
    }

    /**
     * By definition, a prime number is a number that is
     * divisible only by 1 and itself.
     *
     * @param p positive Integer value
     * @param q positive Integer value
     * @return true if greatest common divider of p and q
     * is 1. Otherwise, false.
     */
    private static boolean commonlyPrime(int p, int q) {
        return gcd(p, q) == 1;
    }

    /**
     * Generates an n-by-n array.
     * @param n number of rows/columns in 2D array
     * @return 2D array
     */
    public static boolean[][] generate(int n) {
        boolean[][] arr = new boolean[n][n];

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                arr[i][j] = commonlyPrime(i, j);
            }
        }

        return arr;
    }

    /**
     * Prints a 2D array in a readable form.
     * @param arr 2D array
     */
    public static void print(boolean[][] arr) {
        int n = arr.length;

        StdOut.println("Generated matrix:");

        StdOut.printf("%3s |", "#");
        for (int i = 0; i < n; i++) StdOut.printf("%7d", i);
        StdOut.printf("%n");

        StdOut.printf("%s%n", "-".repeat(5 + n * 7));

        for (int i = 0; i < n; i++) {
            StdOut.printf("%3d |", i);
            for (int j = 0; j < n; j++) StdOut.printf("%7b", arr[i][j]);
            StdOut.printf("%n");
        }
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        print(generate(n));
    }
}
