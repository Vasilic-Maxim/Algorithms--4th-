package chapter1.section3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import utils.SmartDate;

public class Exercise_16 {
    private static SmartDate[] readDates() {
        Bag<SmartDate> bag = new Bag<>();
        while (!StdIn.isEmpty())
            bag.add(new SmartDate(StdIn.readString()));

        int n = bag.size(), i = 0;
        SmartDate[] dates = new SmartDate[n];
        for (SmartDate date : bag) dates[i++] = date;

        return dates;
    }

    public static void main(String[] args) {
        SmartDate[] dates = readDates();
        for (SmartDate date : dates) StdOut.println(date);
    }
}
