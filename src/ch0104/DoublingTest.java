package ch0104;

import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;

/**
 * Created by qinbingbing on 10/9/16.
 */
public class DoublingTest {
    public static double timeTrial(int n) {
        int max = 1000000;
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform(-max, max);
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapseTime();
    }

    public static void main(String[] args) {
        for (int n = 250; ; n += n) {
            double time = timeTrial(n);
            StdOut.printf("%7d %5.1f\n", n, time);
        }
    }
}
