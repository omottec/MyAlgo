package std;

import java.awt.geom.Point2D;

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


}
