package ch01;
//import In;

import com.omottec.algo.stdio.In;
import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

import java.util.Arrays;

/**
 * Created by qinbingbing on 9/23/16.
 * javac ch01/BinarySearch.java
 * java ch01.BinarySearch ../algs4-data/tinyW.txt < ../algs4-data/tinyT.txt
 */
public class BinarySearch {
    private BinarySearch() {}

    /**
     * Searches for the integer key in the sorted array a[].
     * @param key
     * @param a
     * @return  index of key in array a[] if present; -1 if not present
     */
    public static int rank(int key, int[] a) {
        int lo = 0, hi = a.length - 1, mid;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        int[] whiteList = in.readAllInts();
        System.out.println("whiteList before sort:" + Arrays.toString(whiteList));
        Arrays.sort(whiteList);
        System.out.println("whiteList after sort:" + Arrays.toString(whiteList));
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            if (rank(key, whiteList) == -1)
                StdOut.println(key);
        }
    }
}
