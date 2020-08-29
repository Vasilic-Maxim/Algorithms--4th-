package chapter1.section1;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_35 {
    /**
     * @return probability distribution for the sum of two dice.
     */
    public static double[] simulation() {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];
        for (int i = 1; i <= SIDES; i++)
            for (int j = 1; j <= SIDES; j++)
                dist[i + j] += 1.0;

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }

    /**
     * @param trials number of experiments we will process.
     * @return probability distribution for the sum of two dice
     * thrown "trials" times.
     */
    public static double[] experiment(int trials) {
        int SIDES = 6;
        double[] dist = new double[2 * SIDES + 1];

        for (int i = 0; i < trials; i++) {
            int first = StdRandom.uniform(1, 7);
            int second = StdRandom.uniform(1, 7);
            dist[first + second]++;
        }

        for (int k = 2; k <= 2 * SIDES; k++)
            dist[k] /= 36.0;

        return dist;
    }

    /**
     * @param title text to display before data.
     * @param data  from simulation and experiments.
     */
    public static void print(String title, double[] data) {
        StdOut.printf("%s:%n", title);
        for (double item : data)
            StdOut.printf("%.3f  ", item);
        StdOut.println();
    }

    public static void main(String[] args) {
        int trials = StdRandom.uniform(1000000);
        double[] simulation = simulation();
        double[] experiment = experiment(trials);

        print("Simulation results", simulation);
        print("Experiment results", experiment);
    }
}
