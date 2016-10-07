package ch0103;

import java.util.Iterator;

/**
 * Created by qinbingbing on 9/29/16.
 */
public class Stack<T> implements Iterable<T> {
    private Node first;
    private int n;

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void push(T item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        n++;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        n--;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private Node node = first;

        @Override
        public boolean hasNext() {
            return node != null;
        }

        @Override
        public T next() {
            T item = node.item;
            node = node.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    private class Node {
        T item;
        Node next;
    }
}
