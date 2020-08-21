import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_23 {
    public static int[] whitelist(int len) {
        int prev = 0;
        int[] whitelist = new int[len];
        for (int i = 0; i < len; i++) {
            whitelist[i] = StdRandom.uniform(prev + 1, prev + len);
            prev = whitelist[i];
        }

        return whitelist;
    }

    public static int rank(int key, int[] a) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }

        return -1;
    }

    public static void main(String[] args) {
        boolean showAbsent = args[0].equals("+");
        // If you want you can create a file with numbers but I prefer
        // to automate the process of generating a new list.
        int[] whitelist = whitelist(15);

        StdOut.printf("Whitelist: %s%n", Arrays.toString(whitelist));

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int result = rank(key, whitelist);

            if (showAbsent && result == -1) StdOut.printf("The key '%d' was not found in whitelist.%n", key);
            else if (!showAbsent && result != -1) StdOut.printf("The key '%d' was found in whitelist.%n", key);
        }
    }
}
