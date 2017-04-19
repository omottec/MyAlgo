package ch0301;

import ch0103.Queue;

/**
 * Created by qinbingbing on 10/14/16.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] values;
    private int N;
    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        values = (Value[]) new Object[capacity];
    }

    public int size() { return N; }

    public boolean isEmpty() { return N == 0; }

    public int rank(Key key) {
        int lo = 0, hi = N-1, mid;
        while (lo <= hi) {
            mid = lo + (hi-lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp > 0) lo = mid + 1;
            else if (cmp < 0) hi = mid - 1;
            else return mid;
        }
        return lo;
    }

    public Value get(Key key) {
        if (isEmpty()) return null;
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) return values[i];
        else return null;
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) {
            values[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j-1];
            values[j] = values[j-1];
        }
        keys[i] = key;
        values[i] = val;
        N++;
    }

    public Key min() {
        if (isEmpty()) return null;
        return keys[0];
    }

    public Key max() {
        if (isEmpty()) return null;
        return keys[N-1];
    }

    public Key select(int k) {
        if (k < N) return keys[k];
        else return null;
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        if (i < N) return keys[i];
        else return null;
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return key;
        else if (i > 0 && key.compareTo(keys[i-1]) > 0) return keys[i-1];
        else return null;
    }

    public boolean contains(Key key) {
        if (isEmpty()) return false;
        int i = rank(key);
        if (i < N && key.compareTo(keys[i]) == 0) return true;
        else return false;
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> q = new Queue<Key>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.enqueue(keys[i]);
        if (contains(hi)) q.enqueue(hi);
        return q;
    }
}
