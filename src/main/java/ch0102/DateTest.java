package ch0102;

import com.omottec.algo.stdio.StdOut;
import std.Interval2D;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class DateTest {
    public static void main(String[] args) {
        int year = Integer.parseInt(args[0]);
        int month = Integer.parseInt(args[1]);
        int day = Integer.parseInt(args[2]);
        StdOut.println(new SmallDate(year, month, day));
    }
}
