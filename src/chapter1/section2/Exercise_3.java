package chapter1.section2;

import edu.princeton.cs.algs4.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Exercise_3 {
    private static final int MIN_SCALE = 0;
    private static final int MAX_SCALE = 100;

    /**
     * Setup basic drawing properties.
     */
    private static void setupCanvas() {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(MIN_SCALE, MAX_SCALE);
        StdDraw.setYscale(MIN_SCALE, MAX_SCALE);
        StdDraw.enableDoubleBuffering();
    }

    /**
     * @param n number of intervals.
     * @return array of 2D intervals.
     */
    private static HashMap<Interval2D, Interval1D[]> generate(int n, int minLength, int maxLength) {
        StdDraw.setPenRadius(0.005);
        HashMap<Interval2D, Interval1D[]> result = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Interval1D xInterval = generate(minLength, maxLength);
            Interval1D yInterval = generate(minLength, maxLength);
            Interval2D interval = new Interval2D(xInterval, yInterval);
            result.put(interval, new Interval1D[]{xInterval, yInterval});
            interval.draw();
        }

        return result;
    }

    /**
     * @return an randomly generated interval.
     */
    private static Interval1D generate(int minLength, int maxLength) {
        int min = StdRandom.uniform(MAX_SCALE - maxLength);
        int length = StdRandom.uniform(minLength, maxLength);
        return new Interval1D(min, min + length);
    }

    /**
     * @param intervals array of 2D intervals.
     */
    private static void count(HashMap<Interval2D, Interval1D[]> intervals) {
        Counter intersects = new Counter("intersects");
        Counter contains = new Counter("contains");
        ArrayList<Interval2D> keys = new ArrayList<>(intervals.keySet());
        int n = keys.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                Interval2D key1 = keys.get(i);
                Interval2D key2 = keys.get(j);
                if (key1.intersects(key2))
                    intersects.increment();

                if (contains(intervals.get(key1), intervals.get(key2)))
                    contains.increment();

                if (contains(intervals.get(key2), intervals.get(key1)))
                    contains.increment();
            }
        }

        StdOut.printf("Number of 2D intervals that intersects: %d%n", intersects.tally());
        StdOut.printf("Number of 2D intervals that include another interval: %d%n", contains.tally());
    }

    /**
     * @param first  1D intervals of 2D interval.
     * @param second 1D intervals of 2D interval.
     * @return true if first contains second. False otherwise.
     */
    private static boolean contains(Interval1D[] first, Interval1D[] second) {
        Interval1D firstX = first[0], firstY = first[1];
        Interval1D secondX = second[0], secondY = second[1];
        if (!contains(firstX, secondX)) return false;
        return contains(firstY, secondY);
    }

    /**
     * @param first  1D interval (x or y).
     * @param second 1D interval (x or y).
     * @return true if first contains all points of second. False otherwise.
     */
    private static boolean contains(Interval1D first, Interval1D second) {
        if (!first.contains(second.min())) return false;
        return first.contains(second.max());
    }

    public static void main(String[] args) {
        int n = 3;
        int minLength = StdRandom.uniform(1, MAX_SCALE);
        int maxLength = StdRandom.uniform(minLength + 1, MAX_SCALE);

        setupCanvas();

        HashMap<Interval2D, Interval1D[]> intervals = generate(n, minLength, maxLength);
        count(intervals);
        StdDraw.show();
    }
}
