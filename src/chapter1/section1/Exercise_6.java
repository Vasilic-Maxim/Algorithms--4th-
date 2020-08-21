package chapter1.section1;

// Do not forget to install the textbook libraries!
// How to do that you can find by following this
// link: https://algs4.cs.princeton.edu/code/
import edu.princeton.cs.algs4.StdOut;

public class Exercise_6 {
    public static void main(String[] args) {
        // Guys do not be confused. It is an super nice algorithm
        // that calculates first 16 Fibonacci numbers.

        int f = 0;
        int g = 1;
        for (int i = 0; i <= 15; i++) {
            StdOut.println(f);
            f = f + g;
            g = f - g;
        }
    }
}
