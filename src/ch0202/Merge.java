package ch0202;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 10/11/16.
 */
public class Merge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length-1);
    }

    // 自底向上
    private static void sort1(Comparable[] a) {
        int n = a.length;
        aux = new Comparable[n];
        for (int sz = 1; sz < n; sz *= 2) {
            for (int lo = 0; lo + sz < n; lo += 2*sz)
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, n-1));
        }
    }

    // 自顶向下
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi-lo) / 2;
        sort(a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        if (less(a[mid], a[mid+1])) return;
        int i = lo, j = mid + 1;
        Comparable[] aux = new Comparable[a.length];
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
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
//        show(a);
        try {
            assert isSorted(a) : "a is not sorted";
        } catch (AssertionError error) {
            StdOut.println("catch AssertionError");
        }
        sort(a);
        assert isSorted(a);
//        show(a);
    }
}
