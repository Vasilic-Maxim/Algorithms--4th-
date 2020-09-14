package utils;

import edu.princeton.cs.algs4.Stack;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class Buffer {
    Stack<Character> left = new Stack<>();
    Stack<Character> right = new Stack<>();
    private int size = 0;

    /**
     * Inserts a new character into the buffer at the
     * cursor's position.
     *
     * @param c new character to be inserted.
     */
    public void insert(char c) {
        left.push(c);
        size++;
    }

    /**
     * Deletes a character at cursor's position.
     *
     * @return deleted character.
     */
    public char delete() {
        checkSize();
        size--;
        if (!right.isEmpty()) return right.pop();
        return left.pop();
    }

    /**
     * Moves the cursor k positions to the left.
     *
     * @param k steps to move.
     */
    public void left(int k) {
        outOfBounds(left.size(), k);
        for (int i = 0; i < k; i++)
            right.push(left.pop());
    }

    /**
     * Moves the cursor k positions to the right.
     *
     * @param k steps to move.
     */
    public void right(int k) {
        outOfBounds(right.size(), k);
        for (int i = 0; i < k; i++)
            left.push(right.pop());
    }

    /**
     * @return number of characters in the buffer
     */
    public int size() {
        return size;
    }

    /**
     * @return {@code true} if the buffer is empty, {@code false} otherwise.
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @throws NoSuchElementException if trying to delete
     * an element from an empty buffer.
     */
    private void checkSize() {
        if (isEmpty()) throw new NoSuchElementException("The buffer is empty.");
    }

    /**
     * @param size of one of the stacks
     * @param k    number of steps to do
     * @throws IllegalStateException if size is less than k.
     */
    private void outOfBounds(int size, int k) {
        if (size < k) throw new IllegalArgumentException("Number of items is less than number of steps.");
    }

    @Override
    public String toString() {
        char[] buffer = new char[size];

        int position = size - right.size();
        for (char item : right) buffer[position++] = item;

        position = left.size() - 1;
        for (char item : left) buffer[position--] = item;

        return Arrays.toString(buffer);
    }
}
