package utils;

public class SmartDate {
    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int month, int day, int year) {
        validateYear(year);
        validateMonth(month);
        validateDay(month, day, year);

        this.month = month;
        this.day = day;
        this.year = year;
    }

    private void outOfRange(String title, int value, int leftBound, int rightBound) {
        if (value < leftBound || rightBound < value)
            throw new IllegalArgumentException(String.format("%s out of range.", title));
    }

    private void validateDay(int month, int day, int year) {
        int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int daysInMonth = daysPerMonth[month - 1];

        if (month == 2 && isLeapYear(year)) daysInMonth++;
        outOfRange("Day", day, 1, daysInMonth);
    }

    private void validateMonth(int month) {
        outOfRange("Month", month, 1, 12);
    }

    private void validateYear(int year) {
        outOfRange("Year", year, 1700, 4000);
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    /**
     * For more information:
     * https://en.wikipedia.org/wiki/Determination_of_the_day_of_the_week
     *
     * @return name of the day.
     */
    public String dayOfTheWeek() {
        String[] daysNames = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        int[] t = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        int y = year - ((month < 3) ? 1 : 0);
        int index = (y + y / 4 - y / 100 + y / 400 + t[month - 1] + day) % 7;

        return daysNames[index];
    }

    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        SmartDate that = (SmartDate) x;
        if (this.day != that.day) return false;
        if (this.month != that.month) return false;
        return this.year == that.year;
    }
}
