package std;

import com.omottec.algo.stdio.StdDraw;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class VisualAccumulator {
    private double total;
    private int n;
    public VisualAccumulator(int trials, double max) {
        StdDraw.setXscale(0, trials);
        StdDraw.setYscale(0, max);
        StdDraw.setPenRadius(.005);
    }

    public void addDataValue(double val) {
        n++;
        total += val;
        StdDraw.setPenColor(StdDraw.DARK_GRAY);
        StdDraw.point(n, val);
        StdDraw.setPenColor(StdDraw.RED);
        StdDraw.point(n, total/n);
    }

    public double mean() {
        return total / n;
    }

    @Override
    public String toString() {
        return "Mean(" + n + " values): " + String.format("%7.5f", mean());
    }
}
