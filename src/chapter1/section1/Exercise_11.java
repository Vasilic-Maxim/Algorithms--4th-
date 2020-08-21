package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_11 {
    public static boolean[][] generate(int rows, int cols) {
        boolean[][] result = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = StdRandom.bernoulli();
            }
        }

        return result;
    }

    public static void print(boolean[][] matrix) {
        StringBuilder s = new StringBuilder();
        for (boolean[] row : matrix) {
            s.append("|");
            for (int j = 0; j < matrix[0].length; j++)
                s.append(String.format(" %b |", row[j]));
            s.append("\n");
        }

        StdOut.println(s);
    }

    public static void main(String[] args) {
        // If you want you can create and fill the grid on your own, but I
        // prefer to automate this process. That way I can do more test and
        // it will be less time consuming than always changing the grid.
        int rows = 5, cols = 6;
        boolean[][] grid = generate(rows, cols);

        // Show the initial grid in the console.
        StdOut.println("Initial array:");
        print(grid);

        // The main part of the exercise.
        StdOut.println("Contents:");
        for (int i = 0; i < rows; i++) {
            StdOut.print("|");
            for (int j = 0; j < cols; j++) {
                String content = grid[i][j] ? "*" : " ";
                StdOut.printf(" [%d][%d] = %s |", i, j, content);
            }
            StdOut.println();
        }
    }
}
