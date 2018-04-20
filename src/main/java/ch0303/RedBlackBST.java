package ch0303;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by qinbingbing on 20/04/2018.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {
    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;

    private class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private boolean color;
        private int N;

        public Node(Key key, Value val, boolean color, int n) {
            this.key = key;
            this.val = val;
            this.color = color;
            N = n;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
