package utils;

import edu.princeton.cs.algs4.Date;

public class Transaction {
    private final String fullName;
    private final Date date;
    private final double amount;

    public Transaction(String fullName, Date date, double amount) {
        this.fullName = fullName;
        this.date = date;
        this.amount = amount;
    }

    public String fullName() {
        return fullName;
    }

    public Date date() {
        return date;
    }

    public double amount() {
        return amount;
    }

    @Override
    public String toString() {
        return String.format(
                "FullName: %s  Date: %s  Amount: %f",
                fullName, date, amount
        );
    }
}
