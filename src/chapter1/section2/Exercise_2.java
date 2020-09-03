package chapter1.section2;

import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.ArrayList;
import java.util.Arrays;

public class Exercise_2 {
    /**
     * @param n number of intervals.
     * @return an array with intervals.
     */
    public static Interval1D[] generate(int n) {
        Interval1D[] result = new Interval1D[n];
        for (int i = 0; i < n; i++)
            result[i] = generate();

        return result;
    }

    /**
     * @return an randomly generated interval.
     */
    public static Interval1D generate() {
        double min = StdRandom.uniform(0.0, 1.0);
        double max = StdRandom.uniform(min + 0.0001, 1.0);
        return new Interval1D(min, max);
    }

    /**
     * @param intervals array of intervals.
     * @return all pairs of intervals that intersect.
     */
    public static ArrayList<Interval1D[]> intersections(Interval1D[] intervals) {
        int n = intervals.length;
        ArrayList<Interval1D[]> result = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (intervals[i].intersects(intervals[j]))
                    result.add(new Interval1D[]{intervals[i], intervals[j]});
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int n = StdRandom.uniform(10);
        Interval1D[] intervals = generate(n);

        StdOut.println("Intervals that intersect:");
        for (Interval1D[] intersection : intersections(intervals)) {
            StdOut.println(Arrays.toString(intersection));
        }
    }
}
