package ch0102;

import com.omottec.algo.stdio.StdOut;
import com.omottec.algo.stdio.StdRandom;
import std.Counter;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class Flips {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        for (int i = 0; i < n; i++) {
            if (StdRandom.bernoulli(0.5)) heads.increment();
            else tails.increment();
        }
        StdOut.println(heads);
        StdOut.println(tails);
        StdOut.println("delta: " + Math.abs(heads.tally() - tails.tally()));
    }
}
