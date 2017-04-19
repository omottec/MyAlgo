package demo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by omottec on 21/02/2017.
 */
public class CircleDigitsInDivision {
    public static void main(String[] args) {
        int dividend = 9;
        int divisor = 7;
        System.out.println(dividend + " / " + divisor + ": " + circleDigits(dividend, divisor));
    }

    /**
     * 手算发现循环节
     * <p>1. 整除不存在
     * <p>2. 不能整除，将余数乘以10，继续相除
     * <p>3. 当发现有重复的余数时，找到了循环节
     * @param dividend
     * @param divisor
     * @return
     */
    public static String circleDigits(int dividend, int divisor) {
        if (dividend < 0 || divisor <= 0) return null;
        if (dividend % divisor == 0) return null;
        List<Integer> quotientList = new ArrayList<Integer>(); // store dividend/divisor
        List<Integer> leftList = new ArrayList<Integer>(); // store dividend%divisor
        int left = dividend % divisor;
        while (!leftList.contains(left)) {
            leftList.add(left);
            left *= 10;
            quotientList.add(left / divisor);
            left %= divisor;
            if (left == 0) return null;
        }
        int circleBegin = leftList.indexOf(left);
        quotientList = quotientList.subList(circleBegin, quotientList.size());
        StringBuilder sb = new StringBuilder();
        for (Integer i : quotientList)
            sb.append(i);
        return sb.toString();
    }
}
