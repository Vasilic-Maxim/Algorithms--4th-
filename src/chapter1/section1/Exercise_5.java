package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_5 {
    public static boolean isValid(double num) {
        // Check if a number is in a specified range
        return 0.0 < num && num < 1.0;
    }

    public static void main(String[] args) {
        double x = StdRandom.uniform(0.0, 2.0);
        double y = StdRandom.uniform(0.0, 2.0);

        StdOut.printf("X: %f%n", x);
        StdOut.printf("Y: %f%n", y);
        StdOut.printf("Are both numbers strictly between 0.0 and 1.0: %b%n", isValid(x) && isValid(y));
    }
}
