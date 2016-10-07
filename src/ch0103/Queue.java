package ch0103;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

import java.util.Iterator;

/**
 * Created by qinbingbing on 9/30/16.
 */
public class Queue<T> implements Iterable<T> {
    private Node first;
    private Node last;
    private int n;

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }


    private class QueueIterator implements Iterator<T> {
        private Node f = first;

        @Override
        public boolean hasNext() {
            return f != null;
        }

        @Override
        public T next() {
            T item = f.item;
            f = f.next;
            return item;
        }

        @Override
        public void remove() {

        }
    }

    private class Node {
        T item;
        Node next;

        @Override
        public String toString() {
            return item == null ? null : item.toString();
        }
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return n;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        n++;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;
        if (isEmpty()) last = null;
        n--;
        return item;
    }

    public Node head() {
        return first;
    }

    public Node tail() {
        return last;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();
        String item;
        while (!StdIn.isEmpty()) {
            item = StdIn.readString();
            if (!"-".equals(item)) queue.enqueue(item);
            else if (!queue.isEmpty()) StdOut.print(queue.dequeue() + " ");
        }
        StdOut.println("(" + queue.size() + ") left on queue");
        StdOut.println(queue.head());
        StdOut.println(queue.tail());
    }
}
