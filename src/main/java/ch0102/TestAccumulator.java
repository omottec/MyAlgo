package ch0102;

import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;
import std.Accumulator;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class TestAccumulator {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Accumulator accumulator = new Accumulator();
        for (int i = 0; i < n; i++)
            accumulator.addDataValue(StdRandom.uniform());
        StdOut.println(accumulator);
    }
}
