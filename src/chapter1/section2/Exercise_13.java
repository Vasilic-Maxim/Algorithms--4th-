package chapter1.section2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;
import utils.Transaction;

public class Exercise_13 {
    public static void main(String[] args) {
        String fullName = "John Smith";
        Date date = new Date(11, 29, 2020);
        double amount = 4.99;
        Transaction transaction = new Transaction(fullName, date, amount);

        StdOut.println(transaction);
    }
}
