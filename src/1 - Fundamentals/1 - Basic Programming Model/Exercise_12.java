import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_12 {
    public static void main(String[] args) {
        // Initialize an array of length 10 and fill with
        // numbers from 0 to 10 (excluding) in descending
        // order. The result will look like this:
        // [9, 8, 7, 6, 5, 4, 3, 2, 1, 0]
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = 9 - i;
        StdOut.println(Arrays.toString(a));

        // Create a hill or so called palindrome. The result:
        // [0, 1, 2, 3, 4, 4, 3, 2, 1, 0]
        for (int i = 0; i < 10; i++)
            a[i] = a[a[i]];
        StdOut.println(Arrays.toString(a));

        // Prints all the numbers from 0 to 10 (excluding).
        for (int i = 0; i < 10; i++)
            System.out.println(i);
    }
}
