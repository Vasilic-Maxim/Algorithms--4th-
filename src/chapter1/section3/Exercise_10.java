package chapter1.section3;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Exercise_10 {
    private static final HashMap<String, Integer> ranks = new HashMap<>();

    static {
        ranks.put("+", 1);
        ranks.put("-", 1);
        ranks.put("*", 2);
        ranks.put("/", 2);
        ranks.put("^", 3);
    }

    private static boolean lte(String operator, String lastOperator) {
        if (!ranks.containsKey(operator)) return false;
        if (!ranks.containsKey(lastOperator)) return false;
        return ranks.get(operator) <= ranks.get(lastOperator);
    }

    public static void main(String[] args) {
        String[] input = "( A ^ 2 + B ) * ( C + D ^ 2 )".split(" ");
        Stack<String> opn = new Stack<>();
        Stack<String> opr = new Stack<>();

        for (String symbol : input) {
            if (symbol.equals("(")) opr.push(symbol);
            else if (symbol.equals(")")) {
                while (opr.size() > 0 && !opr.peek().equals("("))
                    opn.push(String.format("%2$s %1$s %3$s", opn.pop(), opn.pop(), opr.pop()));

                opr.pop();
            }
            else if (ranks.containsKey(symbol)) {
                while (opr.size() > 0 && lte(symbol, opr.peek()))
                    opn.push(String.format("%2$s %1$s %3$s", opn.pop(), opn.pop(), opr.pop()));

                opr.push(symbol);
            }
            else opn.push(symbol);
        }

        opn.push(String.format("%2$s %1$s %3$s", opn.pop(), opn.pop(), opr.pop()));

        StdOut.printf("%s", opn.peek());
    }
}
