package chapter1.section3;

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Exercise_8 {
    public static void main(String[] args) {
        String[] input = "it was - the best - of times - - - it was - the - -".split(" ");
        DoublingStackOfStrings stack = new DoublingStackOfStrings();
        for (String s : input) stack.push(s);

        StdOut.print("Contents: ");
        for (String s : stack) StdOut.printf("%s ", s);
        StdOut.println();
        StdOut.printf("Real size: %d%n", stack.realSize());
        // NOTE: The real length always will be equal to 2 raised to some power.
    }

    public static class DoublingStackOfStrings implements Iterable<String> {
        private String[] a = new String[1];
        private int N = 0;

        public boolean isEmpty() {
            return N == 0;
        }

        public int size() {
            return N;
        }

        public int realSize() {
            return a.length;
        }

        private void resize(int max) {
            String[] temp = new String[max];
            if (N >= 0) System.arraycopy(a, 0, temp, 0, N);
            a = temp;
        }

        public void push(String item) {
            if (N == a.length) resize(2 * a.length);
            a[N++] = item;
        }

        public String pop() {
            String item = a[--N];
            a[N] = null;
            if (N > 0 && N == a.length / 4) resize(a.length / 2);
            return item;
        }

        public Iterator<String> iterator() {
            return new ReverseArrayIterator();
        }

        private class ReverseArrayIterator implements Iterator<String> {
            private int i = N;

            public boolean hasNext() {
                return i > 0;
            }

            public String next() {
                return a[--i];
            }

            public void remove() {
            }
        }
    }
}
