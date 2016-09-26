package ch0101;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 9/26/16.
 * java ch0101.Average < data.txt
 * java ch0101.RandomSeq 1000 100.0 200.0 | java ch0101.Average
 */
public class Average {
    public static void main(String[] args) {
        double sum = 0.0;
        int cnt = 0;
        while (!StdIn.isEmpty()) {
            double d = StdIn.readDouble();
            sum += d;
            StdOut.println("read double:" + d);
            cnt++;
        }
        double avg = sum / cnt;
        StdOut.printf("Average is %.5f\n", avg);
    }
}
