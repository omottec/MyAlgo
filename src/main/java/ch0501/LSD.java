package ch0501;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by qinbingbing on 10/19/16.
 * 低位优先的字符串排序
 */
public class LSD {
    public static void sort(String[] a, int W) {
        // 通过前W个字符将a[]排序
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        int[] count;
        for (int d = W-1; d >= 0; d--) {
            // 根据第d个字符用键索引计数法排序
            count = new int[R+1];
            // 计算出现的频率
            for(int i = 0; i < N; i++)
                count[a[i].charAt(d) + 1]++;
            // 将频率转换为索引
            for (int r = 0; r < R; r++)
                count[r+1] += count[r];
            // 将元素分类
            for (int i = 0; i < N; i++)
                aux[count[a[i].charAt(d)]++] = a[i];
            // 回写
            for (int i = 0; i < N; i++)
                a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        String[] strs = StdIn.readAllStrings();
        StdOut.println(Arrays.toString(strs));
        sort(strs, 7);
        StdOut.println(Arrays.toString(strs));
    }
}
