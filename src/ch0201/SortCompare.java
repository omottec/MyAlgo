package ch0201;

import ch0104.Stopwatch;
import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;

/**
 * Created by qinbingbing on 10/11/16.
 */
public class SortCompare {
    public static double time(String alg, Double[] a) {
        Stopwatch timer = new Stopwatch();
        if ("selection".equals(alg)) {
            Selection.sort(a);
        } else if ("insertion".equals(alg)) {
            Insertion.sort(a);
        } else if ("shell".equals(alg)) {
            Shell.sort(a);
        }
        return timer.elapseTime();
    }

    public static double timeRandomInput(String alg, int n, int t) {
        double total = 0.0;
        Double[] a = new Double[n];
        for (int i = 0; i < t; i++) {
            for (int j = 0; j < n; j++)
                a[j] = StdRandom.uniform();
            total += time(alg, a);
        }
        return total;
    }

    public static void main(String[] args) {
        String alg1 = args[0];
        String alg2 = args[1];
        int n = Integer.parseInt(args[2]);
        int t = Integer.parseInt(args[3]);
        double t1 = timeRandomInput(alg1, n, t);
        double t2 = timeRandomInput(alg2, n, t);
        StdOut.printf("For %d random Doubles\n  %s is", n, alg1);
        StdOut.printf(" %.1f times faster than %s\n", t2/t1, alg2);

    }
}
