package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;
import utils.SmartDate;

public class Exercise_12 {
    public static void main(String[] args) {
        // See the implementation of the class in utils.SmartDate.
        SmartDate date = new SmartDate(9, 4, 2020);
        StdOut.println(date.dayOfTheWeek());
    }
}
