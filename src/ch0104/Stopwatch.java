package ch0104;

import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;

/**
 * Created by qinbingbing on 10/9/16.
 */
public class Stopwatch {
    private final long start;
    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    public double elapseTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-1000000, 1000000);
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        double time = timer.elapseTime();
        StdOut.println(cnt + " triples " + time + " seconds");
    }
}
