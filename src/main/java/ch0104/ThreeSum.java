package ch0104;

import com.omottec.algo.stdio.In;
import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 10/9/16.
 */
public class ThreeSum {
    public static int count(int[] a) {
        int n = a.length;
        int cnt = 0;
        for (int i = 0; i < n; i++)
            for (int j = i+1; j < n; j++)
                for (int k = j+1; k < n; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    @SuppressWarnings("deprecation")
    public static void main(String[] args) {
        int[] a = In.readInts(args[0]);
        StdOut.println(count(a));
    }
}
