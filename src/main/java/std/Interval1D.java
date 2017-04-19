package std;

import com.omottec.algo.stdio.StdOut;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by qinbingbing on 9/27/16.
 */
public class Interval1D {
    public static final Comparator<Interval1D> MIN_ENDPOINT_ORDER = new MinEndpointComparator();

    public static final Comparator<Interval1D> MAX_ENDPOINT_ORDER = new MaxEndpointComparator();

    public static final Comparator<Interval1D> LENGTH_ORDER = new LengthComparator();

    private final double min;
    private final double max;

    public Interval1D(double min, double max) {
        if (Double.isInfinite(min) || Double.isInfinite(max))
            throw new IllegalArgumentException("Endpoints must be finite");
        if (Double.isNaN(min) || Double.isNaN(max))
            throw new IllegalArgumentException("Endpoints can not be NaN");
        // convert -0.0 to 0.0
        if (min == 0.0) min = 0.0;
        if (max == 0.0) max = 0.0;
        if (min <= max) {
            this.min = min;
            this.max = max;
        } else {
            throw new IllegalArgumentException("min(" + min + ") > max(" + max + ")");
        }
    }

    public double min() {
        return min;
    }

    public double max() {
        return max;
    }

    public boolean contains(double x) {
        return x >= min && x <= max;
    }

    public boolean intersects(Interval1D other) {
        if (max < other.min) return false;
        if (min > other.max) return false;
        return true;
    }

    public double length() {
        return max - min;
    }

    @Override
    public String toString() {
        return "[" + min + ", " + max + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Interval1D)) return false;
        Interval1D other = (Interval1D) obj;
        return min == other.min && max == other.max;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((Double)min).hashCode();
        result = 31 * result + ((Double)max).hashCode();
        return result;
    }

    private static class MinEndpointComparator implements Comparator<Interval1D> {

        @Override
        public int compare(Interval1D o1, Interval1D o2) {
            if (o1.min < o2.min) return -1;
            else if (o1.min > o2.min) return 1;
            else if (o1.max < o2.max) return -1;
            else if (o1.max > o2.max) return 1;
            else return 0;
        }
    }

    private static class MaxEndpointComparator implements Comparator<Interval1D> {

        @Override
        public int compare(Interval1D o1, Interval1D o2) {
            if (o1.max < o2.max) return -1;
            else if (o1.max > o2.max) return 1;
            else if (o1.min < o2.min) return -1;
            else if (o1.max > o2.max) return 1;
            else return 0;
        }
    }

    private static class LengthComparator implements Comparator<Interval1D> {

        @Override
        public int compare(Interval1D o1, Interval1D o2) {
            double o1Len = o1.length();
            double o2Len = o2.length();
            if (o1Len < o2Len) return -1;
            else if (o1Len > o2Len) return 1;
            else return 0;
        }
    }

    public static void main(String[] args) {
        Interval1D[] intervals = {
                new Interval1D(15.0, 33.0),
                new Interval1D(45.0, 60.0),
                new Interval1D(20.0, 70.0),
                new Interval1D(46.0, 55.0)
        };
        StdOut.println("Unsorted");
        int length = intervals.length;
        for (int i = 0; i < length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by min endpoint");
        Arrays.sort(intervals, MIN_ENDPOINT_ORDER);
        for (int i = 0; i < length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by max endpoint");
        Arrays.sort(intervals, MAX_ENDPOINT_ORDER);
        for (int i = 0; i < length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();

        StdOut.println("Sort by length");
        Arrays.sort(intervals, LENGTH_ORDER);
        for (int i = 0; i < length; i++)
            StdOut.println(intervals[i]);
        StdOut.println();
    }
}
