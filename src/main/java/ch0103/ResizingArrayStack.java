package ch0103;

import java.util.Iterator;

/**
 * Created by qinbingbing on 9/29/16.
 */
public class ResizingArrayStack<T> implements Iterable<T> {
    private T[] a = (T[]) new Object[1];
    private int n;

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int max) {
        T[] tmp = (T[]) new Object[max];
        for (int i = 0; i < n; i++)
            tmp[i] = a[i];
        a = tmp;
    }

    public void push(T t) {
        if (n == a.length) resize(2 * n);
        a[n++] = t;
    }

    public T pop() {
        if (n == 0) return null;
        T t = a[--n];
        a[n] = null;
        if (n > 0 && n == a.length/4) resize(a.length / 2);
        return t;
    }

    @Override
    public Iterator<T> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<T> {
        private int i = n;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public T next() {
            return a[--i];
        }

        @Override
        public void remove() {

        }
    }
}
