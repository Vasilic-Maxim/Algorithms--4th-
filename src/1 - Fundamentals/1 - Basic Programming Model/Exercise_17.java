import edu.princeton.cs.algs4.StdOut;

public class Exercise_17 {
    public static String exR2(int n) {
        String s = exR2(n - 3) + n + exR2(n - 2) + n;

        // When you deal with recursion you have to be very careful
        // with base cases. If they are absent or like in this example,
        // placed after the recursive call, then the infinite loop is
        // inevitable.
        if (n <= 0) return "";
        return s;
    }

    public static void main(String[] args) {
        // You can try it... StackOverflowError should be raised.
        StdOut.println(exR2(6));
    }
}
