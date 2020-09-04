package chapter1.section2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

import java.util.Arrays;

public class Exercise_10 {
    public static void main(String[] args) {
        int n = StdRandom.uniform(15, 30);
        int max = StdRandom.uniform(5, 15);
        VisualCounter counter = new VisualCounter(n, max);
        double[] stats = getStats(n, counter);

        StdOut.printf("Stats: %s%n", Arrays.toString(stats));

        StdDraw.setYscale(-1, max);
        StdStats.plotBars(stats);
    }

    /**
     * @param trials  number of experiments.
     * @param counter counter.
     * @return statistics of counter changes.
     */
    private static double[] getStats(int trials, VisualCounter counter) {
        double[] stats = new double[trials];
        for (int i = 0; i < trials; i++) {
            if (StdRandom.bernoulli()) counter.increment();
            else counter.decrement();
            stats[i] = Math.abs(counter.tally());
        }
        return stats;
    }

    static class VisualCounter {
        private final int max;
        private int n, tally = 0;

        /**
         * @param n   maximum number of operations one can do with this counter.
         * @param max absolute max value for tally.
         */
        public VisualCounter(int n, int max) {
            this.n = n;
            this.max = max;
        }

        /**
         * Increments tally by 1.
         */
        private void increment() {
            if (n == 0) return;
            if (tally < max) tally++;
            n--;
        }

        /**
         * Decrements tally by 1.
         */
        private void decrement() {
            if (n == 0) return;
            if (Math.abs(tally) < max) tally--;
            n--;
        }

        /**
         * @return tally.
         */
        private int tally() {
            return tally;
        }
    }
}
