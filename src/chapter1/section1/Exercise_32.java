package chapter1.section1;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Exercise_32 {
    public static void main(String[] args) {
        int n = StdRandom.uniform(2, 11);
        double left = 0.0, right = 1.0;
        int entries = StdRandom.uniform(1000);
        Histogram histogram = new Histogram(n, left, right);

        for (int i = 0; i <= entries; i++)
            histogram.add(StdRandom.uniform(left, right));

        histogram.draw();
    }

    private static class Histogram {
        private final int n;
        private final double left, interval;
        private final double[] frequency;
        private double maxFrequency;

        public Histogram(int n, double start, double end) {
            this.n = n;
            this.left = start;
            this.frequency = new double[n];
            this.interval = (end - start) / n;
        }

        /**
         * Increments interval frequency by 1.
         * @param value between start and end
         */
        public void add(double value) {
            int index = (int) ((value - left) / interval);
            frequency[index]++;
            if (frequency[index] > maxFrequency)
                maxFrequency = frequency[index];
        }

        /**
         * Draws the histogram.
         */
        public void draw() {
            StdDraw.setCanvasSize(500, 100);
            StdDraw.setYscale(-1, maxFrequency + 1);
            StdDraw.setXscale(-1, n);
            for (int i = 0; i < n; i++) {
                StdDraw.setPenColor(randomColor());
                double halfHeight = frequency[i] / 2;
                StdDraw.filledRectangle(i, halfHeight, 0.25, halfHeight);
            }
        }

        /**
         * @return a randomly generated color.
         */
        private static Color randomColor() {
            int red = StdRandom.uniform(256);
            int green = StdRandom.uniform(256);
            int blue = StdRandom.uniform(256);
            return new Color(red, green, blue);
        }
    }
}
