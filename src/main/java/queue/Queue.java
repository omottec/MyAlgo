package queue;

import java.util.Iterator;

/**
 * Created by qinbingbing on 26/04/2017.
 */
public interface Queue<T> extends Iterable<T> {
    void enqueue(T item);

    T dequeue();

    T head();

    T tail();

    boolean isEmpty();

    int size();
}
