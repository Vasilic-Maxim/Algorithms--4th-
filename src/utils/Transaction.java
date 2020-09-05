package utils;

public class Transaction {
    private final String customer;
    private final SmartDate date;
    private final double amount;

    public Transaction(String fullName, SmartDate date, double amount) {
        this.customer = fullName;
        this.date = date;
        this.amount = amount;
    }

    public Transaction(String data) {
        String[] fields = data.split(" ");
        customer = fields[0];
        date = new SmartDate(fields[1]);
        amount = Double.parseDouble(fields[2]);
    }

    public String customer() {
        return customer;
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
                customer, date, amount
        );
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        Transaction that = (Transaction) x;
        if (amount != that.amount) return false;
        if (!customer.equals(that.customer)) return false;
        return date.equals(that.date);
    }
}
