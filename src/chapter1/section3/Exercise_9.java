package chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_9 {
    public static void main(String[] args) {
        In in = (new In());
        String[] inputArray = in.readLine().split(" ");
        Stack<String> stack = new Stack<>();

        for (String s : inputArray) {
            if (s.equals(")")) stack.push(String.format("(%3$s %2$s %1$s)", stack.pop(), stack.pop(), stack.pop()));
            else stack.push(s);
        }

        if (!stack.isEmpty())
            throw new IllegalArgumentException("Wrong expression format!");

        StdOut.printf("Output: %s%n", stack.pop());
    }
}
