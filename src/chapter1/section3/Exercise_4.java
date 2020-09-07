package chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Exercise_4 {
    public static void main(String[] args) {
        String input = (new In()).readLine();
        String[] parenthesis = input.split("");
        Stack<String> stack = new Stack<>();
        HashMap<String, String> pairs = new HashMap<>();

        pairs.put(")", "(");
        pairs.put("]", "[");
        pairs.put("}", "{");

        for (String bracket : parenthesis) {
            if (pairs.containsKey(bracket)) {
                emptyStack(stack);
                openBracketsMatch(pairs.get(bracket), stack.pop());
            }
            else stack.push(bracket);
        }

        if (!stack.isEmpty()) unfinishedSequence();

        StdOut.println("Valid sequence!");
    }

    private static void unfinishedSequence() {
        throw new IllegalArgumentException("The sequence of brackets is unfinished.");
    }

    /**
     * @param first  open bracket.
     * @param second open bracket.
     * @throws IllegalArgumentException if brackets do not match.
     */
    private static void openBracketsMatch(String first, String second) {
        if (!first.equals(second))
            throw new IllegalArgumentException("Open and close brackets do not match.");
    }

    /**
     * @param stack collection of brackets.
     * @throws IllegalArgumentException if stack is empty.
     */
    private static void emptyStack(Stack<String> stack) {
        if (stack.isEmpty()) throw new IllegalArgumentException("The stack is empty.");
    }
}
