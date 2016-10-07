package ch0103;

import java.util.Iterator;

/**
 * Created by qinbingbing on 10/7/16.
 */
public class Bag<T> implements Iterable<T> {
    private class Node {
        T item;
        Node next;
    }

    private Node first;
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void add(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class BagIterator implements Iterator<T> {
        private Node current = first;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T result = current.item;
            current = current.next;
            return result;
        }

        @Override
        public void remove() {

        }
    }
}
