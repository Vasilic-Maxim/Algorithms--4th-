package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.RandomBag;

public class Exercise_34 {
    public static void main(String[] args) {
        RandomBag<Integer> bag = new RandomBag<>();
        bag.add(1);
        bag.add(2);
        bag.add(3);
        bag.add(4);
        StdOut.printf("Original order: %s%n", bag);
        StdOut.print("Random order: ");
        for (Integer item : bag) StdOut.printf("%s ", item);
    }
}
