package utils;

import edu.princeton.cs.algs4.StdOut;

public class Rational {
    private static final String OVERFLOW_MESSAGE = "This operation will cause overflow!";
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

    public static void main(String[] args) {
        Rational a = new Rational(3, 7);
        Rational b = new Rational(5, 31);

        StdOut.printf("A equals B: %b%n", a.equals(b));
        StdOut.printf("A plus B: %s%n", a.plus(b));
        StdOut.printf("A minus B: %s%n", a.minus(b));
        StdOut.printf("A times B: %s%n", a.times(b));
        StdOut.printf("A divides B: %s%n", a.divides(b));
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
        assert numerator * b.denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        long aNumerator = numerator * b.denominator;

        assert b.numerator * denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        long bNumerator = b.numerator * denominator;

        assert denominator * b.denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        int newDenominator = (int) (denominator * b.denominator);

        assert aNumerator + bNumerator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        return new Rational((int) (aNumerator + bNumerator), newDenominator);
    }

    /**
     * @param b another rational number.
     * @return difference of this number and b.
     */
    private Rational minus(Rational b) {
        assert numerator * b.denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        long aNumerator = numerator * b.denominator;

        assert b.numerator * denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        long bNumerator = b.numerator * denominator;

        assert denominator * b.denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        int newDenominator = (int) (denominator * b.denominator);

        assert aNumerator - bNumerator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        return new Rational((int) (aNumerator - bNumerator), newDenominator);
    }

    /**
     * @param b another rational number.
     * @return product of this number and b.
     */
    private Rational times(Rational b) {
        assert numerator * b.numerator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        int newNumerator = (int) (numerator * b.numerator);

        assert denominator * b.denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        int newDenominator = (int) (denominator * b.denominator);

        return new Rational(newNumerator, newDenominator);
    }

    /**
     * @param b another rational number.
     * @return quotient of this number and b.
     */
    private Rational divides(Rational b) {
        assert numerator * b.denominator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        int newNumerator = (int) (numerator * b.denominator);

        assert denominator * b.numerator <= Integer.MAX_VALUE : OVERFLOW_MESSAGE;
        int newDenominator = (int) (denominator * b.numerator);

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
}
