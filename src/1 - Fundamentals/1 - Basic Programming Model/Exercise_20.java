import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_20 {
    public static double method1(int num) {
        // The workflow is simple. First, we compute the factorial
        // and then natural logarithm from it.
        double factorial = factorial(num);
        return Math.log(factorial);
    }

    private static double factorial(int num) {
        double result = 1;
        for (; num > 0; num--) result *= num;
        return result;
    }

    public static double method2(int num) {
        // Calculate a natural logarithm value for each member in a factorial
        // sequence. For more details, see:
        // https://stackoverflow.com/a/2095472/4771565
        double result = 0;
        for (; num > 0; num--) result += Math.log(num);
        return result;
    }

    public static void main(String[] args) {
        int num = StdRandom.uniform(20);
        StdOut.printf("Natural logarithm of %d (method #1): %f%n", num, method1(num));
        StdOut.printf("Natural logarithm of %d (method #2): %f%n", num, method2(num));
    }
}
