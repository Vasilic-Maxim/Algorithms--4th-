package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Objects;

public class Exercise_12 {
    private static Stack<String> copy(Stack<String> stack) {
        int n = stack.size();
        if (n == 0) return new Stack<>();

        String[] contents = new String[stack.size()];
        Stack<String> copied = new Stack<>();
        int i = stack.size() - 1;

        for (String s : stack) contents[i--] = s;
        for (String s : contents) copied.push(s);

        return copied;
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("Hello");
        stack.push("World");

        Stack<String> copied = copy(stack);
        StdOut.printf("Initial stack contents: %s%n", stack);
        StdOut.printf("Copied stack contents: %s%n", copied);
        StdOut.printf("Do stack and copied variables refer to the same object? %b", stack == copied);
    }
}
