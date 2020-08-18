public class Exercise_5 {
    public static boolean isValid(double value) {
        return 0.0 < value && value < 1.0;
    }

    public static void main(String[] args) {
        double x = 0.1;
        double y = 0.5;

        // To not repeat myself I created a static method that
        // checks if value of both variables are within the range.
        System.out.println(isValid(x) && isValid(y));
    }
}
