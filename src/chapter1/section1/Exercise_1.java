package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;

@SuppressWarnings("ALL")
public class Exercise_1 {
    public static void main(String[] args) {
        // The priority of each operation in this expression is the same as
        // in regular math. The only tricky part is division. When you
        // divide two numbers of type int, the result also will be int. For
        // more info please check Integer division on wiki.
        //
        // op 1: 0 + 15 = 15
        // op 2: 15 / 2 = 7
        int a = (0 + 15) / 2;
        StdOut.println(a);

        // How to solve this one:
        //
        // op 1: e-6 = 10 ^ -6 = 1 / 1000000
        // op 2: 1 / 1000000.0 * 100000000.1 = 100.1
        // op 3: 100.1 * 2.0 = 200.2
        double b = 2.0e-6 * 100000000.1;
        StdOut.println(b);

        // Boolean comparison... OK. Lets do it!
        //
        // op 1: true && false = false
        // op 2: true && true = true
        // op 3: false || true = true
        boolean c = true && false || true && true;
        StdOut.println(c);
    }
}
