package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_45 {
    public static void main(String[] args) {
        checkPermutation("4 3 2 1 0 9 8 7 6 5".split(" "));
        checkPermutation("4 6 8 7 5 3 2 9 0 1".split(" "));
        checkPermutation("2 5 6 7 4 8 9 3 1 0".split(" "));
        checkPermutation("4 3 2 1 0 5 6 7 8 9".split(" "));
        checkPermutation("1 2 3 4 5 6 9 8 7 0".split(" "));
        checkPermutation("0 4 6 5 3 8 1 7 2 9".split(" "));
        checkPermutation("1 4 7 9 8 6 5 3 0 2".split(" "));
        checkPermutation("2 1 4 3 6 5 8 7 9 0".split(" "));
    }

    private static void checkPermutation(String[] permutation) {
        StdOut.printf(
                "Is %s valid? - %b%n",
                Arrays.toString(permutation),
                isValidPermutation(permutation)
        );
    }

    private static boolean isValidPermutation(String[] permutation) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        for (String character : permutation) {
            int number = Integer.parseInt(character);
            if (stack.isEmpty() || number > stack.peek()) {
                for (; i < number; i++) stack.push(i);
                i++;
            } else if (stack.peek() == number) stack.pop();
            else return false;
        }

        return true;
    }
}
