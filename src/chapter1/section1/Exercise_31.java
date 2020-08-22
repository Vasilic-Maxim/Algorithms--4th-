package chapter1.section1;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.awt.*;

public class Exercise_31 {
    private static final double RADIUS = 0.45;
    private static final double ORIGIN_X = 0.5;
    private static final double ORIGIN_Y = 0.5;
    private static final Color CIRCLE_COLOR = StdDraw.BLACK;
    private static final Color POINT_COLOR = StdDraw.RED;
    private static final Color LINE_COLOR = StdDraw.BLUE;

    /**
     * Change some default settings for drawing.
     */
    private static void setDrawSettings() {
        StdDraw.setPenRadius(0.005);
    }

    /**
     * Draw the circle.
     */
    private static void drawCircle() {
        StdDraw.setPenColor(CIRCLE_COLOR);
        StdDraw.circle(ORIGIN_X, ORIGIN_Y, RADIUS);
    }

    /**
     * Find all points on the circumference.
     *
     * @param numberOfDots number of dots
     * @return all points on a circumference.
     */
    public static Point2D[] findPoints(int numberOfDots) {
        StdDraw.setPenRadius(0.02);
        StdDraw.setPenColor(POINT_COLOR);
        Point2D[] points = new Point2D[numberOfDots];
        double circumference = 2 * Math.PI;
        double angleFactor = circumference / numberOfDots;
        for (int i = 0; i < numberOfDots; i++) {
            double angle = i * angleFactor;

            // Find point's coordinates using parametric equation
            // for a circle. For mo info take a look at:
            // https://en.wikipedia.org/wiki/Circle#Equations
            // https://www.youtube.com/watch?v=aHaFwnqH5CU
            // https://math.stackexchange.com/questions/332743/
            double x = ORIGIN_X + RADIUS * Math.cos(angle);
            double y = ORIGIN_Y + RADIUS * Math.sin(angle);
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        return points;
    }

    /**
     * Try to connect unique pairs of points.
     *
     * @param points      array of points
     * @param probability of a pair of points to be connected
     */
    public static void unify(Point2D[] points, double probability) {
        StdDraw.setPenRadius(0.005);
        StdDraw.setPenColor(LINE_COLOR);
        int numberOfDots = points.length;

        for (int i = 0; i < numberOfDots - 1; i++) {
            for (int j = i + 1; j < numberOfDots; j++)
                unify(points[i], points[j], probability);
        }
    }

    /**
     * Connect two points.
     *
     * @param first       point
     * @param second      point
     * @param probability of two points to be connected
     */
    private static void unify(Point2D first, Point2D second, double probability) {
        if (StdRandom.bernoulli(probability)) {
            StdDraw.line(first.x(), first.y(), second.x(), second.y());
        }
    }

    public static void main(String[] args) {
        // If you want you can rewrite two line below to
        // accept parameters from command line. I just
        // like to automate the processes.
        int numberOfPoints = StdRandom.uniform(1, 10);
        double probability = StdRandom.uniform(0.0, 1.0);

        StdOut.printf("Number on points: %d%n", numberOfPoints);
        StdOut.printf("Probability of union: %f%n", probability);

        setDrawSettings();
        drawCircle();
        unify(findPoints(numberOfPoints), probability);
    }
}
