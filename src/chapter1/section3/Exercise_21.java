package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.LinkedList;

public class Exercise_21 {
    /**
     * For more details about method implementation
     * see the {@link utils.LinkedList#find}
     */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("!");
        list.addFirst("world");
        list.addFirst("Hello");

        StdOut.println(list);
        String wanted = "world";
        StdOut.printf("'%s' was found in Linked List: %b%n", wanted, list.find(wanted));
    }
}
