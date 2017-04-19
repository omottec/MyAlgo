package std;

import com.omottec.algo.stdio.StdDraw;
import com.omottec.algo.stdio.StdRandom;

import java.util.Comparator;

/**
 * Created by qinbingbing on 9/27/16.
 */
public class Point2D implements Comparable<Point2D> {
    private final double x;
    private final double y;

    public Point2D(double x, double y) {
        if (Double.isInfinite(x) || Double.isInfinite(y))
            throw new IllegalArgumentException("Coordinates must be finite");
        if (Double.isNaN(x) || Double.isNaN(y))
            throw new IllegalArgumentException("Coordinates cannot be NaN");
        if (x == 0.0) this.x = 0.0;
        else this.x = x;

        if (y == 0.0) this.y = 0.0;
        else this.y = y;
    }

    public double x() {
        return x;
    }

    public double y() {
        return y;
    }

    public double r() {
        return Math.sqrt(x * x + y * y);
    }

    public double theta() {
        return Math.atan2(y, x);
    }

    public double angleTo(Point2D that) {
        double dx = that.x - x;
        double dy = that.y - y;
        return Math.atan2(dy, dx);
    }

    /**
     * Returns true if a→b→c is a counterclockwise turn.
     * @param a first point
     * @param b second point
     * @param c third point
     * @return { -1, 0, +1 } if a→b→c is a { clockwise, collinear; counterclocwise } turn.
     */
    public static int ccw(Point2D a, Point2D b, Point2D c) {
        double area2 = (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
        if      (area2 < 0) return -1;
        else if (area2 > 0) return +1;
        else                return  0;
    }

    /**
     * Returns twice the signed area of the triangle a-b-c.
     * @param a first point
     * @param b second point
     * @param c third point
     * @return twice the signed area of the triangle a-b-c
     */
    public static double area2(Point2D a, Point2D b, Point2D c) {
        return (b.x-a.x)*(c.y-a.y) - (b.y-a.y)*(c.x-a.x);
    }

    public double distanceTo(Point2D that) {
        double dx = x - that.x;
        double dy = y - that.y;
        return Math.sqrt(dx*dx + dy*dy);
    }

    public double distanceSquaredTo(Point2D that) {
        double dx = x - that.x;
        double dy = y - that.y;
        return dx*dx + dy*dy;
    }

    private static class XOrder implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            if (o1.x < o2.x) return -1;
            if (o1.y > o2.y) return 1;
            return 0;
        }
    }

    private static class YOrder implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            if (o1.y < o2.y) return -1;
            if (o1.y > o2.y) return 1;
            return 0;
        }
    }

    private static class ROrder implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            double delta = o1.r() - o2.r();
            if (delta < 0) return -1;
            if (delta > 0) return 1;
            return 0;
        }
    }

    private class Atan2Order implements Comparator<Point2D> {
        @Override
        public int compare(Point2D o1, Point2D o2) {
            double angle1 = angleTo(o1);
            double angle2 = angleTo(o2);
            if (angle1 < angle2) return -1;
            else if (angle1 > angle2) return 1;
            else return 0;
        }
    }

    // compare other points relative to polar angle (between 0 and 2pi) they make with this Point
    private class PolarOrder implements Comparator<Point2D> {
        @Override
        public int compare(Point2D q1, Point2D q2) {
            double dx1 = q1.x - x;
            double dy1 = q1.y - y;
            double dx2 = q2.x - x;
            double dy2 = q2.y - y;

            if      (dy1 >= 0 && dy2 < 0) return -1;    // q1 above; q2 below
            else if (dy2 >= 0 && dy1 < 0) return +1;    // q1 below; q2 above
            else if (dy1 == 0 && dy2 == 0) {            // 3-collinear and horizontal
                if      (dx1 >= 0 && dx2 < 0) return -1;
                else if (dx2 >= 0 && dx1 < 0) return +1;
                else                          return  0;
            }
            else return -ccw(Point2D.this, q1, q2);     // both above or below

            // Note: ccw() recomputes dx1, dy1, dx2, and dy2
        }
    }

    private class DistanceToOrder implements Comparator<Point2D> {

        @Override
        public int compare(Point2D o1, Point2D o2) {
            double dist1 = distanceSquaredTo(o1);
            double dist2 = distanceSquaredTo(o2);
            if (dist1 < dist2) return -1;
            else if (dist1 > dist2) return 1;
            else return 0;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point2D)) return false;
        Point2D that = (Point2D) obj;
        return x == that.x && y == that.y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Double)x).hashCode();
        result = 31 * result + ((Double)y).hashCode();
        return result;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point2D that) {
        StdDraw.line(x, y, that.x, that.y);
    }

    public int compareTo(Point2D o) {
        if (y < o.y) return -1;
        else if (y > o.y) return 1;
        else if (x < o.x) return -1;
        else if (x > o.x) return 1;
        else return 0;
    }

    public static void main(String[] args) {
        int x0 = Integer.parseInt(args[0]);
        int y0 = Integer.parseInt(args[1]);
        int n = Integer.parseInt(args[2]);

        StdDraw.setCanvasSize(800, 800);
        StdDraw.setXscale(0, 100);
        StdDraw.setYscale(0, 100);
        StdDraw.setPenRadius(.005);
        Point2D[] points = new Point2D[n];
        for (int i = 0; i < n; i++) {
            int x = StdRandom.uniform(100);
            int y = StdRandom.uniform(100);
            points[i] = new Point2D(x, y);
            points[i].draw();
        }

        Point2D p = new Point2D(x0, y0);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.setPenRadius(.02);
        p.draw();
    }
}
