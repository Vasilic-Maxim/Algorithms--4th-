package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_36 {
    /**
     * @param a an array with numbers (0, a.length]
     */
    public static void shuffle(double[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int r = i + StdRandom.uniform(N - i);
            double temp = a[i];
            a[i] = a[r];
            a[r] = temp;
        }
    }

    /**
     * @param len    length of the initial array.
     * @param trials number of experiments.
     */
    public static void shuffleTest(int len, int trials) {
        int[][] statistics = new int[len][len];
        double[] initial = new double[len];
        for (int i = 0; i < len; i++) initial[i] = i;

        for (int i = 0; i < trials; i++) {
            double[] copy = initial.clone();
            shuffle(copy);

            for (int j = 0; j < len; j++)
                statistics[j][(int) copy[j]] += 1;
        }

        print(statistics, trials);
    }

    /**
     * @param statistics statistics of number i appearing on
     *                   position j for all j.
     * @param trials     number of experiment made.
     */
    private static void print(int[][] statistics, int trials) {
        StdOut.printf("By doing %d experiments we gain these results:%n", trials);
        for (int[] row : statistics)
            StdOut.printf("%s%n", Arrays.toString(row));
        StdOut.println();

        double ideal = (double) trials / statistics.length;
        StdOut.printf("Number of times i wound up in position j for all j (ideally): %.3f", ideal);
    }

    public static void main(String[] args) {
        int m = StdRandom.uniform(3, 11);
        int n = StdRandom.uniform(1000, 10000);

        shuffleTest(m, n);
    }
}
