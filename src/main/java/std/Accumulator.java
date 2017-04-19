package std;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class Accumulator {
    private double total;
    private int n;

    public void addDataValue(double val) {
        n++;
        total += val;
    }

    public double mean() {
        return total / n;
    }

    @Override
    public String toString() {
        return "Mean(" + n + " values): " + String.format("%7.5f", mean());
    }
}
