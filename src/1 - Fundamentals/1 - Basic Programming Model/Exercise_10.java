import java.util.Arrays;

public class Exercise_10 {
    public static void main(String[] args) {
        // In the book's code the variable 'a' wast declared but
        // the value was not assigned. In case when you want to
        // fill and array with some data, you have first to
        // allocate some space for that data. Code below is right
        // way to do it.
        int[] a = new int[10];
        for (int i = 0; i < 10; i++)
            a[i] = i * i;

        System.out.println(Arrays.toString(a));
    }
}
