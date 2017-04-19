package ch0102;

import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;
import std.VisualAccumulator;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class TestVisualAccumulator {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        VisualAccumulator a = new VisualAccumulator(n, 1.0);
        for (int i = 0; i < n; i++)
            a.addDataValue(StdRandom.uniform());
        StdOut.println(a);
    }
}
