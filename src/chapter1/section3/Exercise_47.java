package chapter1.section3;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import utils.CircularQueue;
import utils.Steque;

public class Exercise_47 {
    private static CircularQueue<Integer> queuesCatenation(Queue<Integer> first, Queue<Integer> second) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        while (!first.isEmpty()) circularQueue.enqueue(first.dequeue());
        while (!second.isEmpty()) circularQueue.enqueue(second.dequeue());
        return circularQueue;
    }

    private static CircularQueue<Integer> stacksCatenation(Stack<Integer> first, Stack<Integer> second) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        while (!first.isEmpty()) circularQueue.enqueue(first.pop());
        while (!second.isEmpty()) circularQueue.enqueue(second.pop());
        return circularQueue;
    }

    private static CircularQueue<Integer> stequesCatenation(Steque<Integer> first, Steque<Integer> second) {
        CircularQueue<Integer> circularQueue = new CircularQueue<>();
        while (!first.isEmpty()) circularQueue.enqueue(first.pop());
        while (!second.isEmpty()) circularQueue.enqueue(second.pop());
        return circularQueue;
    }

    public static void main(String[] args) {
        Queue<Integer> firstQueue = new Queue<>();
        Queue<Integer> secondQueue = new Queue<>();
        Stack<Integer> firstStack = new Stack<>();
        Stack<Integer> secondStack = new Stack<>();
        Steque<Integer> firstSteque = new Steque<>();
        Steque<Integer> secondSteque = new Steque<>();

        for (int i = 0; i < 5; i++) {
            int item = StdRandom.uniform(100);
            StdOut.printf("Inserted: %s%n", item);
            firstQueue.enqueue(item);
            firstStack.push(item);
            firstSteque.push(item);
        }

        for (int i = 0; i < 4; i++) {
            int item = StdRandom.uniform(100);
            StdOut.printf("Inserted: %s%n", item);
            secondQueue.enqueue(item);
            secondStack.push(item);
            secondSteque.push(item);
        }

        StdOut.printf("First queue:         %s%n", firstQueue);
        StdOut.printf("Second queue:        %s%n", secondQueue);
        StdOut.printf("Queues catenation:   %s%n", queuesCatenation(firstQueue, secondQueue));
        StdOut.printf("First stack:         %s%n", firstStack);
        StdOut.printf("Second stack:        %s%n", secondStack);
        StdOut.printf("Stacks catenation:   %s%n", stacksCatenation(firstStack, secondStack));
        StdOut.printf("First steque:        %s%n", firstSteque);
        StdOut.printf("Second steque:       %s%n", secondSteque);
        StdOut.printf("Steques catenation:  %s%n", stequesCatenation(firstSteque, secondSteque));
    }
}
