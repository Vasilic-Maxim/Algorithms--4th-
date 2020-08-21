package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_14 {
    public static int lg(int num) {
        // To find logarithm base 2 of a number, divide the
        // number by 2 until it becomes 1. Why one? I know it
        // is not polite to answer with a question, but what
        // power of 2 gives us 1? If your answer is 0 then
        // you got it right!
        int base = 0;
        for (; num > 1; num /= 2) base++;
        return base;
    }

    public static void main(String[] args) {
        int initial = StdRandom.uniform(100);
        StdOut.printf("The logarithm base 2 of %d = %d", initial, lg(initial));
    }
}
