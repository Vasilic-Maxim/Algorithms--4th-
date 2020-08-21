package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("ALL")
public class Exercise_2 {
    public static void main(String[] args) {
        // There is one thing to remember: if you do some operations on
        // Integer values, and at some point appears Double value, then
        // Integer values will be converted into Double.
        //
        // op 1: 1 + 2.236 = 3.236
        // op 2: 3.236 / 2.0 = 1.618
        double a = (1 + 2.236) / 2;
        StdOut.println(a);

        // The same as "a"...
        //
        // op 1: 1 + 2 = 3
        // op 2: 3 + 3 = 6
        // op 3: 6.0 + 4.0 = 10.0
        double b = 1 + 2 + 3 + 4.0;
        StdOut.println(b);

        // By checking if one value is greater than the other, we will
        // receive a boolean value as a result!
        boolean c = 4.1 >= 4;
        StdOut.println(c);

        // Everything will go according to the Math's plan... until you
        // met the "3"...
        //
        // op 1: 1 + 2 = 3
        // op 2: 3 + "3" = "33"
        String d = 1 + 2 + "3";
        StdOut.println(d);
    }
}
