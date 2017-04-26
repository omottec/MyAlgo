package stack;

import java.util.Iterator;

/**
 * Created by qinbingbing on 25/04/2017.
 */
public class ArrayStack<T> implements Stack<T> {
    private T[] a = (T[]) new Object[1];
    private int n;

    @Override
    public void push(T item) {
        if (n == a.length) resize(2 * n);
        a[n++] = item;
    }

    @Override
    public T pop() {
        if (n == 0) return null;
        T t = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length / 4) resize(a.length / 2);
        return t;
    }

    @Override
    public boolean isEmpty() {
        return n == 0;
    }

    @Override
    public int size() {
        return n;
    }

    private void resize(int max) {
        T[] tmp = (T[]) new Object[max];
        for (int i = 0; i < n; i++)
            tmp[i] = a[i];
        a = tmp;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int i = n;
        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (n == 0) {
            sb.append("[]");
        } else {
            sb.append("[");
            for (T t : this)
                sb.append(t).append(", ");
            sb = new StringBuilder(sb.substring(0, sb.lastIndexOf(", ")));
            sb.append("]");
        }
        return sb.toString();
    }
}
