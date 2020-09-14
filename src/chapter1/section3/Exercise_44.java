package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.Buffer;

public class Exercise_44 {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        int n = 5;
        for (int i = 0; i < n; i++) {
            char item = (char) StdRandom.uniform(97, 123);
            buffer.insert(item);
            StdOut.printf("Inset: %s%n", item);
        }

        StdOut.printf("Buffer: %s%n", buffer);
        buffer.left(3);
        buffer.insert('a');
        buffer.insert('b');
        buffer.right(1);
        buffer.insert('c');
        StdOut.printf("Buffer: %s%n", buffer);
    }
}
