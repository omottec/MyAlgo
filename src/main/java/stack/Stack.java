package stack;

/**
 * Created by qinbingbing on 25/04/2017.
 */
public interface Stack<T> extends Iterable<T> {
    void push(T item);

    T pop();

    boolean isEmpty();

    int size();
}
