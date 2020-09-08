package chapter1.section3;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import utils.Transaction;

public class Exercise_17 {
    private static Transaction[] readDates() {
        Bag<Transaction> bag = new Bag<>();
        while (!StdIn.isEmpty())
            bag.add(new Transaction(StdIn.readLine()));

        int n = bag.size(), i = 0;
        Transaction[] transactions = new Transaction[n];
        for (Transaction transaction : bag)
            transactions[i++] = transaction;

        return transactions;
    }

    public static void main(String[] args) {
        Transaction[] transactions = readDates();
        for (Transaction transaction : transactions)
            StdOut.println(transaction);
    }
}
