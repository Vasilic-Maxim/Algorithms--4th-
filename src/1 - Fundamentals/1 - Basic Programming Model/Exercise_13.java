import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_13 {
    public static int[][] generate(int rows, int cols) {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = StdRandom.uniform(10);
            }
        }

        return result;
    }

    public static int[][] transpose(int[][] initial, int rows, int cols) {
        int[][] result = new int[cols][rows];
        // For each coordinate (i, j) in initial matrix we have to copy the
        // value into (j, i) in transposed matrix.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = initial[i][j];
            }
        }

        return result;
    }

    public static void print(int[][] matrix) {
        StringBuilder s = new StringBuilder();
        for (int[] row : matrix) {
            s.append("|");
            for (int j = 0; j < matrix[0].length; j++)
                s.append(String.format(" %3d |", row[j]));
            s.append("\n");
        }

        StdOut.println(s);
    }

    public static void main(String[] args) {
        // Create an initial matrix and fill it with random values. Create
        // the second, transposed matrix.
        int rows = 3, cols = 7;
        int[][] initial = generate(rows, cols);
        int[][] transposed = transpose(initial, rows, cols);

        // Print the results in console.
        StdOut.println("Initial matrix:");
        print(initial);
        StdOut.println("Transposed matrix:");
        print(transposed);

        // To learn more about transposition in matrices please follow this link:
        // https://en.wikipedia.org/wiki/Transpose
    }
}
