package ch0203;

import java.util.Arrays;

public class Quick003 {
    public static void main(String[] args) {
        Integer[] intArray = {2,3,5,9,6,4,23,11,27,0,1};
        System.out.println("intArray before: " + Arrays.toString(intArray));
        quickSort(intArray, 0, intArray.length - 1);
        System.out.println("intArray after: " + Arrays.toString(intArray));

        String[] strArray = {"q","u","i","c","k","s","o","r","t","e","x","a","m","p","l","e"};
        System.out.println("strArray before:" + Arrays.toString(strArray));
        quickSort(strArray, 0, strArray.length - 1);
        System.out.println("strArray after:" + Arrays.toString(strArray));
    }

    public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (array == null || low >= high) return;
        int l = low;
        int h = high + 1;
        T pivot = array[low];
        while (true) {
            while (l < high && array[++l].compareTo(pivot) <= 0)
                ;
            while (h > low && array[--h].compareTo(pivot) >= 0)
                ;
            if (l < h) {
                T tmp = array[l];
                array[l] = array[h];
                array[h] = tmp;
            } else {
                if (h != low) {
                    array[low] = array[h];
                    array[h] = pivot;
                }
                break;
            }
        }
        quickSort(array, low, h - 1);
        quickSort(array, h + 1, high);
    }
}
