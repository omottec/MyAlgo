package ch0201;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 10/11/16.
 */
public class Shell {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h /= 3;
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        if (i == j) return;
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++)
            StdOut.print(a[i] + " ");
        StdOut.println();
    }

    public static boolean isSorted(Comparable[] a) {
        int length = a.length;
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        String[] a = StdIn.readAllStrings();
        show(a);
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
