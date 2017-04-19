package ch0201;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 10/11/16.
 */
public class Selection {
    public static void sort(Comparable[] a) {
        int n = a.length;
        int min;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j = i+1; j < n; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
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
