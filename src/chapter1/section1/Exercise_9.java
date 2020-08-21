package chapter1.section1;

public class Exercise_9 {
    public static String toBinaryString1(int n) {
        // Probably the most obvious way to do that is to just
        // call built-in method of Integer class.
        return Integer.toBinaryString(n);
    }

    public static String toBinaryString2(int n) {
        // To know that some API exists is great. But can you
        // how it solves the problem? By the way if you are
        // wandering why I use StringBuilder() instead of
        // concatenation with "+" sign, please check out this
        // link: https://stackoverflow.com/questions/1532461/
        StringBuilder s = new StringBuilder();
        for (int div = n; div > 0; div /= 2)
            s.append(div % 2);

        return s.reverse().toString();
    }

    public static void main(String[] args) {
        int num = 100000;
        System.out.println(toBinaryString1(num));
        System.out.println(toBinaryString2(num));
    }
}
