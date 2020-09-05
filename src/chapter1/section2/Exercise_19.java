package chapter1.section2;

import edu.princeton.cs.algs4.StdOut;
import utils.SmartDate;
import utils.Transaction;

public class Exercise_19 {
    public static void main(String[] args) {
        String fullName = "John Smith";
        SmartDate date = new SmartDate("11/29/2020");
        double amount = 4.99;
        Transaction transaction = new Transaction(fullName, date, amount);

        StdOut.println(transaction);
    }
}
