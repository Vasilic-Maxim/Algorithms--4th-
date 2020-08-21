package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_7 {
    public static void partA() {
        double t = 9.0;
        while (Math.abs(t - 9.0 / t) > .001)
            t = (9.0 / t + t) / 2.0;
        StdOut.printf("%.5f\n", t);
    }

    public static void partB() {
        int sum = 0;
        for (int i = 1; i < 1000; i++)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    public static void partC() {
        // IMPORTANT: Code in book was printed with a mistake. Instead
        // of N there should be 1000. See the official page about all
        // mistakes in book: https://algs4.cs.princeton.edu/errata/errata-printing1.php
        int sum = 0;
        for (int i = 1; i < 1000; i *= 2)
            for (int j = 0; j < i; j++)
                sum++;
        StdOut.println(sum);
    }

    public static void main(String[] args) {
        partA(); // 3.00009
        partB(); // 499500
        partC(); // 1023
    }
}
