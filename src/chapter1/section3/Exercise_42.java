package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_42 {
    public static void main(String[] args) {
        Stack<Integer> initial = new Stack<>();
        Stack<Integer> clone = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        int n = StdRandom.uniform(5, 10);

        for (int i = 0; i < n; i++)
            initial.push(StdRandom.uniform(10));

        for (int i = 0; i < n; i++)
            temp.push(initial.pop());

        for (int i = 0; i < n; i++) {
            int item = temp.pop();
            initial.push(item);
            clone.push(item);
        }

        StdOut.printf("Initial: %s%n", initial);
        StdOut.printf("Clone:   %s%n", clone);
    }
}
