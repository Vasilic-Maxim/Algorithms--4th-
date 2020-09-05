package utils;

import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private final long numerator;
    private final long denominator;

    /**
     * @param numerator   any integer value.
     * @param denominator any integer value, except zero.
     * @throws IllegalArgumentException if denominator is zero.
     */
    public Rational(int numerator, int denominator) {
        nonZeroDenominator(denominator);

        long gcd = gcd(numerator, denominator);
        if (gcd > 1) {
            numerator /= gcd;
            denominator /= gcd;
        }

        if (denominator < 0) {
            numerator *= -1;
            denominator *= -1;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * @param numerator   any integer value.
     * @param denominator any integer value, except zero.
     * @throws IllegalArgumentException if denominator is zero.
     */
    private Rational(long numerator, long denominator) {
        long gcd = gcd(numerator, denominator);
        if (gcd > 1) {
            numerator /= gcd;
            denominator /= gcd;
        }

        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * @param numerator   number.
     * @param denominator number.
     * @return greatest common divisor.
     */
    private long gcd(long numerator, long denominator) {
        if (denominator == 0) return numerator;
        return gcd(denominator, numerator % denominator);
    }

    /**
     * @param denominator number.
     * @throws IllegalArgumentException if denominator is zero.
     */
    private void nonZeroDenominator(int denominator) {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator must not be equal to 0");
    }

    /**
     * @param b another rational number.
     * @return sum of this number and b.
     */
    private Rational plus(Rational b) {
        long aNumerator = numerator * b.denominator;
        long bNumerator = b.numerator * denominator;
        long newDenominator = denominator * b.denominator;
        return new Rational(aNumerator + bNumerator, newDenominator);
    }

    /**
     * @param b another rational number.
     * @return difference of this number and b.
     */
    private Rational minus(Rational b) {
        long aNumerator = numerator * b.denominator;
        long bNumerator = b.numerator * denominator;
        long newDenominator = denominator * b.denominator;
        return new Rational(aNumerator - bNumerator, newDenominator);
    }

    /**
     * @param b another rational number.
     * @return product of this number and b.
     */
    private Rational times(Rational b) {
        long newNumerator = numerator * b.numerator;
        long newDenominator = denominator * b.denominator;
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * @param b another rational number.
     * @return quotient of this number and b.
     */
    private Rational divides(Rational b) {
        long newNumerator = numerator * b.denominator;
        long newDenominator = denominator * b.numerator;
        return new Rational(newNumerator, newDenominator);
    }

    /**
     * @param object object to compare with.
     * @return is this number equal to that?
     */
    public boolean equals(Object object) {
        if (object == null) return false;
        if (object == this) return true;
        if (this.getClass() != object.getClass()) return false;
        Rational that = (Rational) object;
        if (numerator != that.numerator) return false;
        return denominator == that.denominator;
    }

    /**
     * @return string representation
     */
    public String toString() {
        return String.format(
                "numerator=%d denominator=%d",
                numerator, denominator
        );
    }

    public static void main(String[] args) {
        Rational a = new Rational(1, 7);
        Rational b = new Rational(3, 5);

        StdOut.printf("A equals B: %b%n", a.equals(b));
        StdOut.printf("A plus B: %s%n", a.plus(b));
        StdOut.printf("A minus B: %s%n", a.minus(b));
        StdOut.printf("A times B: %s%n", a.times(b));
        StdOut.printf("A divides B: %s%n", a.divides(b));
    }
}
