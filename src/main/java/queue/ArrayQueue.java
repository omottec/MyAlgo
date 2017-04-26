package queue;

import java.util.Iterator;

/**
 * Created by qinbingbing on 26/04/2017.
 */
public class ArrayQueue<T> implements Queue<T> {
    private T[] a = (T[]) new Object[1];
    private int head;
    private int tail;

    private void resize(int max) {
        T[] tmp = (T[]) new Object[max];
        for (int i = head; i < tail; i++)
            tmp[i - head] = a[i];
        a = tmp;
        tail = tail - head;
        head = 0;
    }

    @Override
    public void enqueue(T item) {
        if (tail == a.length) resize(a.length * 2);
        a[tail++] = item;
    }

    @Override
    public T dequeue() {
        if (head == tail) return null;
        T item = a[head];
        a[head++] = null;
        if (size() > 0 && size() == a.length / 4) resize(a.length / 2);
        return item;
    }

    @Override
    public T head() {
        return a[head];
    }

    @Override
    public T tail() {
        if (isEmpty()) return null;
        else return a[tail - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public int size() {
        return tail - head;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator<T> {
        private int h = head;
        private int t = tail;

        @Override
        public boolean hasNext() {
            return h < t;
        }

        @Override
        public T next() {
            return a[h++];
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (size() == 0) {
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
