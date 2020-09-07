package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

public class Exercise_2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        String[] input = "it was - the best - of times - - - it was - the - -".split(" ");
        for (String s : input) stack.push(s);
        for (String s : stack) StdOut.printf("%s ", s);
    }
}
