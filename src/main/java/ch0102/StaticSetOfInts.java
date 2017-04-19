package ch0102;

import com.omottec.algo.stdio.StdOut;

import java.util.Arrays;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class StaticSetOfInts {
    private int[] a;
    public StaticSetOfInts(int[] keys) {
        a = Arrays.copyOf(keys, keys.length);
        StdOut.println("keys hash:" + keys);
        StdOut.println("a hash:" + a);
//        StdOut.println("keys elements:" + Arrays.toString(keys));
//        StdOut.println("a elements:" + Arrays.toString(a));
        Arrays.sort(a);
    }

    public boolean contains(int key) {
        return rank(a, 0, a.length-1, key) != -1;
    }

    private int rank(int[] a, int lo, int hi, int key) {
        if (lo > hi) return -1;
        int mid = lo + (hi-lo)/2;
        if (key  < a[mid]) return rank(a, lo, mid-1, key);
        else if (key > a[mid]) return rank(a, mid+1, hi, key);
        else return mid;
    }
}
