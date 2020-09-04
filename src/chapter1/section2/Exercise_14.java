package chapter1.section2;

import edu.princeton.cs.algs4.Date;
import edu.princeton.cs.algs4.StdOut;
import utils.Transaction;

public class Exercise_14 {
    public static void main(String[] args) {
        String fullName = "John Smith";
        Date date = new Date(11, 29, 2020);
        double amount = 4.99;
        Transaction transaction1 = new Transaction(fullName, date, amount);
        Transaction transaction2 = new Transaction(fullName, date, amount);

        StdOut.println(transaction1);
        StdOut.println(transaction2);
        StdOut.printf("Transactions are equal: %b", transaction1.equals(transaction2));
    }
}
