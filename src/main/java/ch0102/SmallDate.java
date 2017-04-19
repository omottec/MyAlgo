package ch0102;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class SmallDate {
    private final int value;

    public SmallDate(int year, int month, int day) {
        value = 512 * year + 32 * month + day;
    }

    public int getYear() {
        return value / 512;
    }

    public int getMonth() {
        return (value/32) % 16;
    }

    public int getDay() {
        return value % 32;
    }

    @Override
    public String toString() {
        return getYear() + "/" + getMonth() + "/" + getDay();
    }
}
