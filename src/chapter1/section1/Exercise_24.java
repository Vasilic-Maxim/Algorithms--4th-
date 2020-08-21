package chapter1.section1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_24 {
    public static int gcd(int p, int q) {
        StdOut.printf("Computing GCD for %d and %d%n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        StdOut.printf("Result: %d%n", gcd(105, 24));

        int p = StdIn.readInt(), q = StdIn.readInt();
        if (p <= 0) throw new IllegalArgumentException("P must be a non-negative integer.");
        if (q <= 0) throw new IllegalArgumentException("Q must be a non-negative integer.");
        StdOut.printf("Result: %d%n", gcd(p, q));

        StdOut.printf("Result: %d%n", gcd(1111111, 1234567));
    }
}
