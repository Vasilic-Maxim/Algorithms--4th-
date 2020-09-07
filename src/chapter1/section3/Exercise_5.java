package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_5 {
    public static void main(String[] args) {
        // The code below computes the binary representation of any number.

        int N = 50;
        Stack<Integer> stack = new Stack<>();

        while (N > 0) {
            StdOut.println(N);
            stack.push(N % 2);
            N = N / 2;
        }

        for (int d : stack) StdOut.print(d);
        StdOut.println();
    }
}
