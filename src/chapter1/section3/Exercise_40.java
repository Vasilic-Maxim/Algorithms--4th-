package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.MoveToFront;

public class Exercise_40 {
    public static void main(String[] args) {
        MoveToFront<Character> cache = new MoveToFront<>();
        int n = 10;
        for (int i = 0; i < n; i++) {
            char item = (char) StdRandom.uniform(97, 123);
            cache.add(item);
            StdOut.printf("%s: %s%n", item, cache);
        }
    }
}
