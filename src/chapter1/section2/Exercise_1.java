package chapter1.section2;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Exercise_1 {
    /**
     * Setup basic drawing properties.
     */
    public static void setupCanvas() {
        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.enableDoubleBuffering();
    }

    /**
     * @param n number of points to generate.
     * @return array of points.
     */
    public static Point2D[] generate(int n) {
        StdDraw.setPenRadius(0.01);
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        return points;
    }

    /**
     * @param points array of points.
     * @return pair of closest points.
     */
    public static Point2D[] findClosest(Point2D[] points) {
        int n = points.length;
        Point2D[] closestPoints = new Point2D[2];
        double minDistance = Double.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = points[i].distanceSquaredTo(points[j]);
                if (distance < minDistance) {
                    minDistance = distance;
                    closestPoints = new Point2D[]{points[i], points[j]};
                }
            }
        }

        return closestPoints;
    }

    /**
     * @param first  point.
     * @param second point.
     */
    public static void connect(Point2D first, Point2D second) {
        StdDraw.setPenRadius();
        StdDraw.setPenColor(StdDraw.RED);
        first.drawTo(second);
    }

    public static void main(String[] args) {
        int n = StdRandom.uniform(10, 20);
        setupCanvas();
        Point2D[] points = generate(n);
        Point2D[] closest = findClosest(points);
        connect(closest[0], closest[1]);
        StdDraw.show();
    }
}
