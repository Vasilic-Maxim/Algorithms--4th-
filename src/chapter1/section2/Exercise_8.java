package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_8 {
    /**
     * @return an array of random numbers.
     */
    private static int[] generate() {
        int n = 1000000;
        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = StdRandom.uniform(n);
        return result;
    }

    @SuppressWarnings("PrimitiveArrayArgumentToVarargsMethod")
    public static void main(String[] args) {
        int[] a = generate(), b = generate();
        StdOut.printf("Initial address of the array 'a': %s%n", a);
        StdOut.printf("Initial address of the array 'b': %s%n", b);

        // This code changes the references of the variables
        // a and b. Millions of the numbers would not be copied
        // from one array to another and vice versa. So, the
        // answer is 'Yes!'. This is the most efficient way to
        // do that.
        int[] t = a; a = b; b = t;

        StdOut.printf("Address of the array 'a' after switching: %s%n", a);
        StdOut.printf("Address of the array 'b' after switching: %s%n", b);
    }
}
