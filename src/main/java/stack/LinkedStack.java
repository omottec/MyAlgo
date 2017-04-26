package stack;

import java.util.Iterator;

/**
 * Created by qinbingbing on 25/04/2017.
 */
public class LinkedStack<T> implements Stack<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node top;
    private int n;

    @Override
    public void push(T item) {
        Node oldTop = top;
        top = new Node();
        top.item = item;
        top.next = oldTop;
        n++;
    }

    @Override
    public T pop() {
        if (top == null) return null;
        T item = top.item;
        top = top.next;
        n--;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {
        private Node t = top;

        @Override
        public boolean hasNext() {
            return t != null;
        }

        @Override
        public T next() {
            T item = t.item;
            t = t.next;
            return item;
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
