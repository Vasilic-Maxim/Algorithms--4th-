package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_26 {
    public static void main(String[] args) {
        int a = StdRandom.uniform(100);
        int b = StdRandom.uniform(100);
        int c = StdRandom.uniform(100);
        if (a > b) {
            int t = a;
            a = b;
            b = t;
        }
        if (a > c) {
            int t = a;
            a = c;
            c = t;
        }
        if (b > c) {
            int t = b;
            b = c;
            c = t;
        }

        StdOut.printf("Order: %d <= %d <= %d", a, b, c);
    }
}
