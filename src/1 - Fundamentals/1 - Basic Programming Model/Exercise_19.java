import edu.princeton.cs.algs4.StdOut;

import java.util.HashMap;

public class Exercise_19 {
    public static long FibonacciBrute(int n) {
        // Why this method is so slow? The answer is obvious
        // then you drew the tree of the computation. The
        // same Fibonacci numbers are computed over and over
        // again in different branches.
        //
        // Here is the complexity of the algorithm:
        // Time complexity:     O(2 ^ n)
        // Space complexity:    O(log n)
        if (n == 0) return 0;
        if (n == 1) return 1;
        return FibonacciBrute(n - 1) + FibonacciBrute(n - 2);
    }

    public static long FibonacciMemo(int n) {
        // If we want to save some time computing the numbers we have to
        // store somewhere results of computations, so then some particular
        // number appears again we would be able to return the result
        // immediately. That technique is called memoization.
        //
        // Lets talk about complexity:
        // Time complexity:     O(n)
        // Space complexity:    O(n)
        //
        // We sacrificed some space, but saved a lot of time! If you figured
        // this solution on your own then you should be proud about yourself!
        HashMap<Integer, Long> memo = new HashMap<>();
        memo.put(0, 0L);
        memo.put(1, 1L);
        return FibonacciMemo(n, memo);
    }

    private static long FibonacciMemo(int n, HashMap<Integer, Long> memo) {
        if (memo.containsKey(n)) return memo.get(n);

        long first = FibonacciMemo(n - 1, memo);
        long second = FibonacciMemo(n - 2, memo);
        memo.put(n, Long.sum(first, second));
        return memo.get(n);
    }

    private static long FibonacciPro(int n) {
        // And here how pro's do. They still take the full advantage of
        // memoization but shorten the space significantly. Lets break it
        // down! We have 0 and 1 Fibonacci numbers. So, we can compute the
        // next number using them. As you probably already mentioned, we
        // need just two numbers to compute the next one. Then there is no
        // sense to keep all the computed numbers...
        //
        // Complexity:
        // Time complexity:     O(n)
        // Space complexity:    O(1)
        //
        // Bravo!!! We did it!!!

        long result = 0L, helper = 1L;
        for (int i = 1; i <= n; i++) {
            result = result + helper;
            helper = result - helper;
        }

        return result;
    }

    public static void main(String[] args) {
        for (int n = 0; n < 100; n++) {
            StdOut.printf("%d Fibonacci number:%n", n);
            // On approximately 40th number you might become bored from
            // waiting the next number. Just comment next line... Enjoy!
            StdOut.printf("FibonacciBrute:  %d%n", FibonacciBrute(n));
            StdOut.printf("FibonacciMemo:   %d%n", FibonacciMemo(n));
            StdOut.printf("FibonacciPro:    %d%n", FibonacciPro(n));
        }
    }
}
