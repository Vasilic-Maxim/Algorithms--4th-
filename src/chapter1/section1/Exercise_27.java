/*
 * Warning: the book was printed with several mistakes. This
 * exercise contains two mistakes. For more information,
 * please visit book's site:
 * https://algs4.cs.princeton.edu/errata/errata-printing1.php
 *
 * Some help:
 * https://stackoverflow.com/a/16762412/4771565
 * */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_27 {
    private static int calls1 = 0;
    private static int calls2 = 0;

    /**
     * You can compare this algorithm with naive algorithm that
     * computes n-th Fibonacci number. The pattern is exactly the
     * same. First try to represent this problem as a tree. You
     * will see that for each node that represents a recursive call
     * we create two children-nodes for k and k-1. It means that
     * for each next level there would be twice more nodes that in
     * previous one. As a result we will visit 2 ^ n (2 raised to
     * power of n) nodes. Worst case appears when n <= k.
     *
     * Time:    O(2 ^ n)
     * Space:   O(n)
     *
     * @param n random number
     * @param k trials
     * @param p probability
     * @return result
     */
    public static double binomial1(int n, int k, double p) {
        calls1++;
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial1(n - 1, k, p) + p * binomial1(n - 1, k - 1, p);
    }

    /**
     * As in Fibonacci algorithms lets use memoization technique. The
     * only difference is that now we have to track two values: n and
     * k. How would we store them? Well... I can suggest two options:
     * HashMap/HashTable or 2D array. Both will work well and have
     * their trade-offs. I will use a matrix as it was required by
     * problem statement.
     *
     * Time:    O(n * k)
     * Space:   O(n * k)
     *
     * @param n random number
     * @param k trials
     * @param p probability
     * @return result
     */
    public static double binomial2(int n, int k, double p) {
        double[][] memo = new double[n + 1][k + 1];

        // Fill the entire matrix with some special value. For me it would
        // be -1, but you can choose any negative number on your preference.
        for (double[] row : memo) Arrays.fill(row, -1);

        return helper(n, k, p, memo);
    }

    private static double helper(int n, int k, double p, double[][] memo) {
        calls2++;
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        if (memo[n][k] >= 0) return memo[n][k];

        memo[n][k] = (1.0 - p) * helper(n - 1, k, p, memo) + p * helper(n - 1, k - 1, p, memo);

        return memo[n][k];
    }

    /**
     * From the beginning we had a recursive solution. After that we figured
     * out how we can store once computed results in a @d array. So, we used
     * memoization. And what happen when you have both recursion + memoization?
     * Right! You search for a way to use dynamic programming!
     *
     * Time:    O(n * k)
     * Space:   O(n * k)
     *
     * @param n random number
     * @param k trials
     * @param p probability
     * @return result
     */
    public static double binomial3(int n, int k, double p) {
        double[][] memo = new double[n + 1][k + 1];
        memo[0][0] = 1.0;

        for (int i = 1; i <= n; i++) memo[i][0] = Math.pow(1 - p, i);

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                memo[i][j] = (1.0 - p) * memo[i - 1][j] + p * memo[i - 1][j - 1];
            }
        }

        return memo[n][k];
    }

    public static void main(String[] args) {
        int n = 100, k = 50;
        double p = StdRandom.uniform(0.4, 0.6);
        StdOut.printf("Probability: %f%n", p);

        // Uncomment only to compare results of methods. Do not
        // use n and k with values bigger than 40. It will take
        // a lot of time...
        // StdOut.printf("[Recursion] Result: %f%n", binomial(n, k, p));
        // StdOut.printf("[Recursion] Number of calls: %d%n", calls);
        StdOut.printf("[Recursion + Memo] Result: %f%n", binomial2(n, k, p));
        StdOut.printf("[Recursion + Memo] Number of calls: %d%n", calls2);
        StdOut.printf("[Dynamic Programming] Result: %f%n", binomial3(n, k, p));
        StdOut.printf("[Dynamic Programming] Number of calls: %d%n", n * k);
    }
}
