package ch0103;

/**
 * Created by qinbingbing on 9/29/16.
 */
public class FixedCapacityStack<T> {
    private T[] a;
    private int n;

    @SuppressWarnings("unchecked")
    public FixedCapacityStack(int cap) {
        a = (T[]) new Object[cap];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        a[n++] = item;
    }

    public T pop() {
        return a[--n];
    }
}
