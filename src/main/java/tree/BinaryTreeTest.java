package tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by omottec on 06/02/2020.
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        Node<String> a = new Node<>();
        a.t = "A";
        Node<String> b = new Node<>();
        b.t = "B";
        Node<String> c = new Node<>();
        c.t = "C";
        a.left = b;
        a.right = c;
        Node<String> d = new Node<>();
        d.t = "D";
        Node<String> e = new Node<>();
        e.t = "E";
        Node<String> f = new Node<>();
        f.t = "F";
        Node<String> g = new Node<>();
        g.t = "G";
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        System.out.println("traverseWidth");
        traverseWidth(a);
        System.out.println("\ntraverseDepth");
        traverseDepth(a);
    }

    public static class Node<T> {
        public T t;
        public Node<T> left;
        public Node<T> right;

        @Override
        public String toString() {
            return t.toString();
        }
    }

    public static <T> void traverseWidth(Node<T> root) {
        LinkedList<Node<T>> list = new LinkedList<>();
        list.offerFirst(root);
        while (!list.isEmpty()) {
            Node<T> tmp = list.pollLast();
            System.out.print(tmp.t + " ");
            if (tmp.left != null)
                list.offerFirst(tmp.left);
            if (tmp.right != null)
                list.offerFirst(tmp.right);
        }
    }

    public static <T> void traverseDepth(Node<T> root) {
        if (root == null) return;
        System.out.print(root.t + " ");
        traverseWidth(root.left);
        traverseWidth(root.right);
    }
}
