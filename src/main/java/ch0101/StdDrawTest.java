package ch0101;

import com.omottec.algo.stdio.StdDraw;
import com.omottec.algo.stdio.StdRandom;

import java.util.Arrays;

/**
 * Created by qinbingbing on 9/26/16.
 */
public class StdDrawTest {
    public static void main(String[] args) {
        drawOrderRectangle();
    }

    private static void drawLine() {
        int N = 100;
        StdDraw.setXscale(0, N);
        StdDraw.setYscale(0, N * N);
        StdDraw.setPenRadius(.01);
        for (int i = 1; i <= N; i++) {
            StdDraw.point(i, i);
            StdDraw.point(i, i * Math.log(i));
            StdDraw.point(i, i * i);
        }
    }

    private static void drawRandomRectangle() {
        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform();
        drawRectangle(a);
    }

    private static void drawOrderRectangle() {
        int n = 50;
        double[] a = new double[n];
        for (int i = 0; i < n; i++)
            a[i] = StdRandom.uniform();
        Arrays.sort(a);
        drawRectangle(a);
    }

    private static void drawRectangle(double[] a) {
        int n = a.length;
        double x, y, rw, rh;
        for (int i = 0; i < n; i++) {
            x = 1.0 * i / n;
            y = a[i] / 2;
            rw = 0.5 / n;
            rh = y;
            StdDraw.filledRectangle(x, y, rw, rh);
        }
    }

}
