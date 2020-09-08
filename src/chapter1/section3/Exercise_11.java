package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashSet;

public class Exercise_11 {
    public static void main(String[] args) {
        String[] input = "7 3 3 * + 10 +".split(" ");
        Stack<String> stack = new Stack<>();
        HashSet<String> commands = new HashSet<>();
        commands.add("+");
        commands.add("-");
        commands.add("*");
        commands.add("/");
        commands.add("^");

        for (String symbol : input) {
            if (commands.contains(symbol)) {
                double second = Double.parseDouble(stack.pop());
                double first = Double.parseDouble(stack.pop());
                double result = 0;

                //noinspection IfCanBeSwitch
                if (symbol.equals("+")) result = first + second;
                else if (symbol.equals("-")) result = first - second;
                else if (symbol.equals("*")) result = first * second;
                else if (symbol.equals("/")) result = first / second;
                else if (symbol.equals("^")) result = (int) first ^ (int) second;

                stack.push(Double.toString(result));
            } else stack.push(symbol);
        }

        StdOut.printf("Result: %s", stack.peek());
    }
}
