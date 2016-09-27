package std;

import com.omottec.algo.stdio.StdDraw;
import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;

/**
 * Created by qinbingbing on 9/27/16.
 */
public class Interval2D {
    private final Interval1D x;
    private final Interval1D y;

    public Interval2D(Interval1D x, Interval1D y) {
        this.x = x;
        this.y = y;
    }

    public boolean intersects(Interval2D other) {
        if (!x.intersects(other.x)) return false;
        if (!y.intersects(other.y)) return false;
        return true;
    }

    public boolean contains(Point2D p) {
        return x.contains(p.x()) && y.contains(p.y());
    }

    public double area() {
        return x.length() * y.length();
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Interval2D)) return false;
        Interval2D that = (Interval2D) obj;
        return x.equals(that.x) && y.equals(that.y);
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + x.hashCode();
        result = 31 * result + y.hashCode();
        return result;
    }

    public void draw() {
        double xc = (x.min() + x.max()) / 2;
        double yc = (y.min() + y.max()) / 2;
        StdDraw.rectangle(xc, yc, x.length()/2, y.length()/2);
    }

    public static void main(String[] args) {
        double xMin = Double.parseDouble(args[0]);
        double xMax = Double.parseDouble(args[1]);
        double yMin = Double.parseDouble(args[2]);
        double yMax = Double.parseDouble(args[3]);
        int trails = Integer.parseInt(args[4]);

        Interval1D xInterval = new Interval1D(xMin, xMax);
        Interval1D yInterval = new Interval1D(yMin, yMax);
        Interval2D box = new Interval2D(xInterval, yInterval);
        box.draw();

        Counter counter = new Counter("hits");
        Point2D point;
        double x, y;
        for (int t = 0; t < trails; t++) {
            x = StdRandom.uniform(0.0, 1.0);
            y = StdRandom.uniform(0.0, 1.0);
            point = new Point2D(x, y);
            if (box.contains(point)) counter.increment();
            else point.draw();
        }

        StdOut.println(counter);
        StdOut.printf("box area = %.2f\n", box.area());
    }
}
