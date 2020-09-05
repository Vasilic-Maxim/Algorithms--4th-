package utils;

public class Transaction {
    private final String fullName;
    private final SmartDate date;
    private final double amount;

    public Transaction(String fullName, SmartDate date, double amount) {
        this.fullName = fullName;
        this.date = date;
        this.amount = amount;
    }

    public Transaction(String fullName, String date, double amount) {
        this.fullName = fullName;
        this.date = new SmartDate(date);
        this.amount = amount;
    }

    public String fullName() {
        return fullName;
    }

    public SmartDate date() {
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

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (amount != that.amount) return false;
        if (!fullName.equals(that.fullName)) return false;
        return date.equals(that.date);
    }
}
