package ch0203;

import java.util.Arrays;

/**
 * Created by qinbingbing on 07/01/2020.
 */
public class Quick001 {
    public static void main(String[] args) {
//        Integer[] array = new Integer[] {};
        String[] array = new String[] {"Q", "U", "I", "C", "K", "S", "O", "R", "T"
                , "E", "X", "A", "M", "P", "L", "E"};
        quickSort(array);
    }

    private static <T extends Comparable<T>> void quickSort(T[] input) {
        if (input == null || input.length == 0)
            throw new IllegalArgumentException("input array can not be null or empty");
        System.out.println("before sort:" + Arrays.toString(input));
        partition(input, 0, input.length - 1);
        System.out.println("after sort:" + Arrays.toString(input));
    }

    private static <T extends Comparable<T>> void partition(T[] array, int low, int high) {
        if (low >= high) return;
        T pivot = array[low];
        int i = low;
        int j = high + 1;
        while (true) {
            while (less(array[++i], pivot))
                if (i == high)
                    break;
            while (less(pivot, array[--j]))
                if (j == low)
                    break;
            if (i >= j) break;
            exch(array, i, j);
        }
        exch(array, low, j);
        partition(array, low, j - 1);
        partition(array, j + 1, high);
    }

    private static <T extends Comparable<T>> boolean less(T t1, T t2) {
        return t1.compareTo(t2) < 0;
    }

    private static <T extends Comparable<T>> boolean greater(T t1, T t2) {
        return t1.compareTo(t2) > 0;
    }

    private static <T extends Comparable<T>> void exch(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
