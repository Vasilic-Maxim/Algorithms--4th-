package chapter1.section3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

public class Exercise_15 {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        String[] contents = (new In()).readLine().split(" ");
        Queue<String> queue = new Queue<>();

        for (String s : contents) queue.enqueue(s);

        int j = 0;
        for (String s : queue) {
            j++;
            if (j >= k) StdOut.println(s);
        }
    }
}
