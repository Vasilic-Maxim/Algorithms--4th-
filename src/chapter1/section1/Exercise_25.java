package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_25 {
    public static int gcd(int p, int q) {
        StdOut.printf("Computing GCD for %d and %d%n", p, q);
        if (q == 0) return p;
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        // The algorithm was explained on Khan Academy,
        // https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm
        // In general the Euclidean algorithm minimizes the
        // bigger problem, making it smaller and solvable.
        int p = StdRandom.uniform(1,100000);
        int q = StdRandom.uniform(1,100000);
        StdOut.printf("Result: %d%n", gcd(p, q));
    }
}
