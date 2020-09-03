package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_4 {
    public static void main(String[] args) {
        String string1 = "hello";
        // Because Strings are immutable, a new string
        // will be created and assigned to string2.
        String string2 = string1;
        string1 = "world";
        StdOut.println(string1); // world
        StdOut.println(string2); // hello
    }
}
