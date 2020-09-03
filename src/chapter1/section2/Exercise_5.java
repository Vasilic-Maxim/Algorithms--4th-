package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_5 {
    @SuppressWarnings("ResultOfMethodCallIgnored")
    public static void main(String[] args) {
        String s = "Hello World";
        // Because 's' is not an object the 'toUpperCase'
        // and 'substring' method would not do any modifications
        // to the initial value.
        s.toUpperCase();
        s.substring(6, 11);
        StdOut.println(s); // Hello World
    }
}
