package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;

public class Exercise_6 {
    /**
     * @param s initial string.
     * @param t rotated string.
     * @return true if t is a circular rotation of s. False otherwise.
     */
    private static boolean isCircularString(String s, String t) {
        if (s.length() != t.length()) return false;
        return (s + s).indexOf(t) > 0;
    }

    public static void main(String[] args) {
        String s = "ACTGACG", t = "TGACGAC";
        StdOut.printf("A string s is a circular rotation of a string t: %b", isCircularString(s, t));
    }
}
