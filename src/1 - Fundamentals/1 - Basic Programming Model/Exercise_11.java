import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_11 {
    private static class Grid {
        private final int rows, cols;
        private final boolean[][] grid;

        public Grid(int rows, int cols) {
            if (rows == 0 || cols == 0)
                throw new IllegalArgumentException("The grid should have more than zero rows and cols!");

            this.rows = rows;
            this.cols = cols;
            this.grid = grid();
        }

        public boolean get(int row, int col) {
            if (!valid(row, col)) throw new IllegalArgumentException("Coordinate out of bounds.");
            return grid[row][col];
        }

        private boolean[][] grid() {
            // Initialize and fill the 2D array with random boolean values.
            boolean[][] grid = new boolean[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    grid[i][j] = StdRandom.bernoulli();
                }
            }

            return grid;
        }

        private boolean valid(int row, int col) {
            return validRow(row) && validCol(col);
        }

        private boolean validRow(int row) {
            return 0 <= row && row < rows;
        }

        private boolean validCol(int col) {
            return 0 <= col && col < cols;
        }

        @Override
        public String toString() {
            StringBuilder s = new StringBuilder();
            for (boolean[] row : grid) {
                s.append("|");
                for (int j = 0; j < grid[0].length; j++)
                    s.append(String.format(" %6b |", row[j]));
                s.append("\n");
            }

            return s.toString();
        }
    }

    public static void main(String[] args) {
        // If you want you can create and fill the grid on your own, but I
        // prefer to automate this process. That way I can do more test and
        // it will be less time consuming than always changing the grid.
        int rows = 5;
        int cols = 6;
        Grid grid = new Grid(rows, cols);

        // Show the initial grid in the console.
        StdOut.println("Initial array:");
        StdOut.println(grid);

        // The main part of the exercise.
        StdOut.println("Contents:");
        for (int i = 0; i < rows; i++) {
            StdOut.print("|");
            for (int j = 0; j < cols; j++) {
                String content = grid.get(i, j) ? "*" : " ";
                StdOut.printf(" [%d][%d] = %s |", i, j, content);
            }
            StdOut.println();
        }
    }
}
