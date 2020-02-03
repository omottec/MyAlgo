package ch0203;

import java.util.Arrays;

/**
 * Created by omottec on 03/02/2020.
 */
public class Quick002 {
    public static void main(String[] args) {
//        String str = "quicksortexample";
        String str = "0123456789";
//        String str = "9876543210";
        Comparable[] array = new Comparable[str.length()];
        for (int i = 0; i < str.length(); i++)
            array[i] = str.charAt(i);
        System.out.println("before sort:\n" + Arrays.toString(array));
        quickSort(array);
        System.out.println("after sort:\n" + Arrays.toString(array));
    }

    public static void quickSort(Comparable[] input) {
        quickSort(input, 0, input.length-1);
    }

    private static void quickSort(Comparable[] input, int low, int high) {
        if (low >= high) return;
        int i = low;
        int j = high + 1;
        Comparable pivot = input[low];
        while (true) {
            //不满足条件停止或扫描到边界停止
            while (noMore(input[++i], pivot))
                if (i >= high)
                    break;
            while (noMore(pivot, input[--j]))
                if (j <= low)
                    break;
            if (i < j) {
                //要么交换元素继续扫描
                exch(input, i, j);
            } else {
                //要么改变pivot的位置，切分数组，中止扫描
                //j指向pivot最终的位置
                exch(input, low, j);
                break;
            }
        }
        quickSort(input, low, j-1);
        quickSort(input, j+1, high);
    }

    private static boolean less(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) < 0;
    }

    private static boolean noMore(Comparable c1, Comparable c2) {
        return c1.compareTo(c2) <= 0;
    }

    private static void exch(Comparable[] array, int i, int j) {
        // 包含i==j 或 i!=j但array[i]=array[j]的两种case
        if (array[i] == array[j]) return;
        Comparable t = array[i];
        array[i] = array[j];
        array[j] = t;
    }
}