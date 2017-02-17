package ch0103;

/**
 * Created by qinbingbing on 9/29/16.
 */
public class FixedCapacityStackOfStrings {
    private String[] a;
    private int n;
    public FixedCapacityStackOfStrings(int cap) {
        a = new String[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(String item) {
        if (n == a.length) return;
        a[n++] = item;
    }

    public String pop() {
        if (n == 0) return null;
        return a[--n];
    }
}
