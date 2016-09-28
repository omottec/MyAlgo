package ch0102;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class BasicDate {
    private final int year;
    private final int month;
    private final int day;

    public BasicDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return year + "/" + month + "/" + day;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BasicDate)) return false;
        BasicDate that = (BasicDate) obj;
        if (year != that.year) return false;
        if (month != that.month) return false;
        if (day != that.day) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + year;
        result = 31 * result + month;
        result = 31 * result + day;
        return result;
    }
}
