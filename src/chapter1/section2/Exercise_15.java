package chapter1.section2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_15 {
    /**
     * @param fileName name of the file.
     * @return array with integers from the file.
     * @throws NumberFormatException if file contains non-numerical elements.
     */
    public static int[] readInts(String fileName) {
        String content = (new In(fileName)).readAll();
        String[] elements = content.split("\\s+");
        int n = elements.length;

        int[] result = new int[n];
        for (int i = 0; i < n; i++)
            result[i] = Integer.parseInt(elements[i]);
        return result;
    }

    public static void main(String[] args) {
        int[] test = readInts("tinyT.txt");
        StdOut.println(Arrays.toString(test));
    }
}
