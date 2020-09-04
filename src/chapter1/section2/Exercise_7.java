package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_7 {
    /**
     * @param s initial string.
     * @return a rotation of the initial string.
     */
    public static String mystery(String s) {
        int N = s.length();
        if (N <= 1) return s;
        String a = s.substring(0, N / 2);
        String b = s.substring(N / 2, N);
        return mystery(b) + mystery(a);
    }

    public static void main(String[] args) {
        String s = "Hello World!";
        StdOut.printf("'%s' was transformed into '%s'", s, mystery(s));
    }
}
