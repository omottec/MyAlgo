package ch0101;

import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;

/**
 * Created by qinbingbing on 9/26/16.
 * java ch0101.RandomSeq 1000 100.0 200.0 > data.txt
 */
public class RandomSeq {
    public static void main(String[] args) {
        int N = Integer.parseInt(args[0]);
        double lo = Double.parseDouble(args[1]);
        double hi = Double.parseDouble(args[2]);
        for (int i = 0; i < N; i++) {
            double x = StdRandom.uniform(lo, hi);
            StdOut.printf("%.2f\n", x);
        }
    }
}
