package std;

import java.util.Comparator;

/**
 * Created by qinbingbing on 9/27/16.
 */
public class Point2D implements Comparator<Point2D> {
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
     * @return { -1, 0, +1 } if a→b→c is a { clockwise, collinear; counterclocwise } turn.
     */
    public static int ccw(Point2D a, Point2D b, Point2D c) {
        return 0;
    }

    @Override
    public int compare(Point2D o1, Point2D o2) {
        return 0;
    }
}
