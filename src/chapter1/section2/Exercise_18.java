package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_18 {
    public static void main(String[] args) {
        double[] array = {12, 3, 14};
        Accumulator ac = new Accumulator();
        for (double num : array) ac.addDataValue(num);

        StdOut.printf("Mean: %f%n", ac.mean());
        StdOut.printf("Var: %f%n", ac.var());
        StdOut.printf("Division: %f%n", ac.stddev());
    }

    public static class Accumulator {
        private double m;
        private double s;
        private int N;

        public Accumulator() {
        }

        public void addDataValue(double x) {
            N++;
            s = s + 1.0 * (N - 1) / N * (x - m) * (x - m);
            m = m + (x - m) / N;
        }

        public double mean() {
            return m;
        }

        public double var() {
            return s / (N - 1);
        }

        public double stddev() {
            return Math.sqrt(this.var());
        }
    }
}
