package queue;

import java.util.Iterator;

/**
 * Created by qinbingbing on 26/04/2017.
 */
public class LinkedQueue<T> implements Queue<T> {
    private Node head;
    private Node tail;
    private int n;

    @Override
    public void enqueue(T item) {
        Node oldTail = tail;
        tail = new Node();
        tail.item = item;
        if (oldTail == null) head = tail;
        else oldTail.next = tail;
        n++;
    }

    @Override
    public T dequeue() {
        if (head == null) return null;
        T item = head.item;
        head = head.next;
        if (head == null) tail = null;
        n--;
        return item;
    }

    @Override
    public T head() {
        return head == null ? null : head.item;
    }

    @Override
    public T tail() {
        return tail == null ? null : tail.item;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    private class Node {
        T item;
        Node next;
    }

    private class LinkedIterator implements Iterator<T> {
        private Node h = head;

        @Override
        public boolean hasNext() {
            return h != null;
        }

        @Override
        public T next() {
            T item = h.item;
            h = h.next;
            return item;
        }
    }
}
