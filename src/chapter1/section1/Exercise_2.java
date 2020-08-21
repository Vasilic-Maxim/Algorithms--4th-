package chapter1.section1;

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
        System.out.println(a);

        // The same as "a"...
        //
        // op 1: 1 + 2 = 3
        // op 2: 3 + 3 = 6
        // op 3: 6.0 + 4.0 = 10.0
        double b = 1 + 2 + 3 + 4.0;
        System.out.println(b);

        // By checking if one value is greater than the other, we will
        // receive a boolean value as a result!
        boolean c = 4.1 >= 4;
        System.out.println(c);

        // Everything will go according to the Math's plan... until you
        // met the "3"...
        //
        // op 1: 1 + 2 = 3
        // op 2: 3 + "3" = "33"
        String d = 1 + 2 + "3";
        System.out.println(d);
    }
}
