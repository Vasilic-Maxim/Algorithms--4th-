import edu.princeton.cs.algs4.StdOut;

public class Exercise_18 {
    public static int mystery1(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return mystery1(a + a, b / 2);
        return mystery1(a + a, b / 2) + a;
    }


    public static int mystery2(int a, int b) {
        if (b == 0) return 1;
        if (b % 2 == 0) return mystery2(a * a, b / 2);
        return mystery2(a * a, b / 2) * a;
    }

    public static void main(String[] args) {
        // First mystery method multiplies two arguments.
        StdOut.println(mystery1(3, 5));
        // Second mystery method raises first argument to
        // the power of the second.
        StdOut.println(mystery2(3, 5));
    }
}
