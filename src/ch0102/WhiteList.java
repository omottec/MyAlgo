package ch0102;

import com.omottec.algo.stdio.In;
import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class WhiteList {
    public static void main(String[] args) {
        int[] w = new In(args[0]).readAllInts();
        StaticSetOfInts set = new StaticSetOfInts(w);
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (!set.contains(key))
                StdOut.println(key);
        }
    }
}
