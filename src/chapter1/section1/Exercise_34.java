package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class Exercise_34 {
    public static void main(String[] args) {
        int n = StdRandom.uniform(4, 10);
        double[] numbers = new double[n];
        double min = Double.MAX_VALUE;
        double max = Double.MIN_VALUE;
        double sum = 0, sumOfSquares = 0;

        // If you want you can redo that code in order to
        // insert data throw standard input.
        for (int i = 0; i < n; i++) {
            double num = StdRandom.uniform(0.0, 1.0);

            min = Math.min(min, num);
            max = Math.max(max, num);
            sum += num;
            sumOfSquares += Math.sqrt(num);
            numbers[i] = num;
        }


        StdOut.printf("Numbers: %s%n", Arrays.toString(numbers));
        StdOut.printf("The minimum number is %f and the maximum number is %f%n", min, max);
        Arrays.sort(numbers);
        StdOut.printf("The median of the numbers is %f%n", median(numbers));
        int k = StdRandom.uniform(n);
        StdOut.printf("The %dth smallest value is %f%n", k + 1, numbers[k]);
        StdOut.printf("The sum of the squares of the numbers is %f%n", sumOfSquares);
        double average = sum / n;
        StdOut.printf("The average of the %d numbers is %f%n", n, average);
        double gtAveragePercentage = (double) 100 / n * gt(numbers, average);
        StdOut.printf("The percentage of numbers greater than the average is %f%%%n", gtAveragePercentage);
        StdOut.printf("The %d numbers in increasing order: %s%n", n, Arrays.toString(numbers));
        StdRandom.shuffle(numbers);
        StdOut.printf("The %d numbers in random order: %s%n", n, Arrays.toString(numbers));
    }

    /**
     * @param numbers array.
     * @return median of the array values.
     */
    private static double median(double[] numbers) {
        int n = numbers.length;
        int mid = n / 2;
        if (n % 2 != 0) return numbers[mid];
        return (numbers[mid - 1] + numbers[mid]) / 2.0;
    }

    /**
     * @param numbers array.
     * @param median  number of the array values.
     * @return number of elements that are greater than the median.
     */
    private static double gt(double[] numbers, double median) {
        int lo = 0;
        int hi = numbers.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] > median) hi = mid - 1;
            else lo = mid + 1;
        }

        return numbers.length - lo;
    }
}
