/*
 * All you need to know about matrix multiplication you can
 * learn from this video:
 * @see https://youtu.be/vzt9c7iWPxs
 */

package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Exercise_33 {
    public static void main(String[] args) {
        double[][] a = {{1, 4, -2}, {3, 5, -6}};
        double[][] b = {{5, 2, 8, -1}, {3, 6, 4, 5}, {-2, 9, 7, -3}};

        StdOut.println("dot(double[] x, double[] y):");
        StdOut.println(Matrix.dot(a[0], a[1]));
        StdOut.println();

        StdOut.println("mult(double[][] a, double[][] b):");
        for (double[] row : Matrix.mult(a, b))
            StdOut.println(Arrays.toString(row));
        StdOut.println();

        StdOut.println("transpose(double[][] a):");
        for (double[] row : Matrix.transpose(a))
            StdOut.println(Arrays.toString(row));
        StdOut.println();

        StdOut.println("mult(double[][] a, double[] x):");
        StdOut.println(Arrays.toString(Matrix.mult(a, a[0])));
        StdOut.println();

        StdOut.println("mult(double[] y, double[][] a):");
        StdOut.println(Arrays.toString(Matrix.mult(a[0], b)));
    }

    public static class Matrix {
        /**
         * @param x vector
         * @param y vector
         * @return product of two vectors.
         * @throws IllegalArgumentException if one of the arguments is null.
         * @throws IllegalArgumentException if arrays' lengths are not equal.
         */
        static double dot(double[] x, double[] y) {
            nullCheck(x);
            nullCheck(y);
            lengthsCheck(x.length, y.length);

            double result = 0;
            for (int i = 0; i < x.length; i++)
                result += x[i] * y[i];

            return result;
        }

        /**
         * @param a first matrix.
         * @param b second matrix.
         * @return matrix product.
         * @throws IllegalArgumentException if one of the matrices is null.
         * @throws IllegalArgumentException if the number of columns in
         *                                  the first matrix is not equal to the number of rows in the
         *                                  second matrix.
         */
        static double[][] mult(double[][] a, double[][] b) {
            nullCheck(a);
            nullCheck(b);

            int fRows = a.length, fCols = a[0].length;
            int sRows = b.length, sCols = b[0].length;
            lengthsCheck(fCols, sRows);

            double[][] bTransposed = transpose(b);
            double[][] result = new double[fRows][sCols];
            for (int i = 0; i < fRows; i++)
                for (int j = 0; j < sCols; j++)
                    result[i][j] = dot(a[i], bTransposed[j]);

            return result;
        }

        /**
         * @param a an M x N matrix
         * @return transposed matrix.
         * @throws IllegalArgumentException if the argument is null.
         */
        static double[][] transpose(double[][] a) {
            nullCheck(a);

            int rows = a.length, cols = a[0].length;
            double[][] result = new double[cols][rows];

            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    result[j][i] = a[i][j];

            return result;
        }

        /**
         * @param a matrix.
         * @param y vector.
         * @return matrix-vector product.
         * @throws IllegalArgumentException if one of the arguments is null.
         * @throws IllegalArgumentException if arrays' lengths are not equal.
         */
        static double[] mult(double[][] a, double[] y) {
            nullCheck(a);
            nullCheck(y);

            int mRows = a.length, mCols = a[0].length;
            int vLength = y.length;
            lengthsCheck(mCols, vLength);

            double[] result = new double[mRows];
            for (int i = 0; i < mRows; i++)
                result[i] = dot(a[i], y);

            return result;
        }

        /**
         * @param x vector.
         * @param a matrix.
         * @return Matrix-vector product.
         */
        static double[] mult(double[] x, double[][] a) {
            nullCheck(x);
            nullCheck(a);

            int vLen = x.length;
            int mRows = a.length, mCols = a[0].length;
            lengthsCheck(vLen, mRows);

            double[][] aTransposed = transpose(a);
            double[] result = new double[mCols];
            for (int i = 0; i < mCols; i++)
                result[i] = dot(x, aTransposed[i]);

            return result;
        }

        /**
         * @param vector 1D array
         * @throws IllegalArgumentException if the argument is null.
         */
        private static void nullCheck(double[] vector) {
            if (vector == null) throw new IllegalArgumentException("Array is required, null received.");
        }

        /**
         * @param matrix 2D array
         * @throws IllegalArgumentException if the argument is null.
         */
        private static void nullCheck(double[][] matrix) {
            if (matrix == null) throw new IllegalArgumentException("Matrix is required, null received.");
        }

        /**
         * @param x some length
         * @param y some length
         * @throws IllegalArgumentException if arrays' lengths are not equal.
         */
        private static void lengthsCheck(int x, int y) {
            if (x != y) throw new IllegalArgumentException("Lengths are not equal.");
        }
    }
}
