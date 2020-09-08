package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;
import utils.LinkedList;

public class Exercise_19 {

    /**
     * For more details about method implementation
     * see the {@link utils.LinkedList#deleteLast}
     */
    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.addFirst("!");
        list.addFirst("world");
        list.addFirst("Hello");

        StdOut.println(list);
        StdOut.printf("Deleted element: %s%n", list.deleteLast());
        StdOut.println(list);
    }
}
