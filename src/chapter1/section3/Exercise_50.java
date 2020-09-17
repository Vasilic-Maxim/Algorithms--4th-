package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.Stack;

public class Exercise_50 {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        for (Integer item : stack) {
            stack.pop();
            StdOut.println(item);
        }
    }
}
