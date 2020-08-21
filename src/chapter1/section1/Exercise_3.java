package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_3 {
    public static void main(String[] args) {
        // If you are working from IntelliJ IDEA:
        // 1 - right click on file or code area
        // 2 - select "Open in Terminal" option
        // 3 - write "java Exercise_3.java 1 1 2"
        // 4 - Enjoy...
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        int c = Integer.parseInt(args[2]);

        if (a == b && b == c) StdOut.println("Equal!");
        else StdOut.println("Not equal!");
    }
}
