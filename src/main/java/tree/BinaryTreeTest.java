package tree;

import java.util.LinkedList;

/**
 * Created by omottec on 06/02/2020.
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        Node<String> a = new Node<>("A");
        Node<String> b = new Node<>("B");
        Node<String> c = new Node<>("C");
        a.left = b;
        a.right = c;
        Node<String> d = new Node<>("D");
        Node<String> e = new Node<>("E");
        Node<String> f = new Node<>("F");
        Node<String> g = new Node<>("G");
        b.left = d;
        b.right = e;
        c.left = f;
        c.right = g;
        Node<String> h = new Node<>("H");
        Node<String> i = new Node<>("I");
        Node<String> j = new Node<>("J");
        Node<String> k = new Node<>("K");
        Node<String> l = new Node<>("L");
        Node<String> m = new Node<>("M");
        d.left = h;
        d.right = i;
        e.left = j;
        f.right = k;
        g.left = l;
        g.right = m;

        System.out.println("traverseWidth");
        traverseWidth(a);
        System.out.println("\ntraverseDepth");
        traverseDepth(a);
    }

    public static class Node<T> {
        public T t;
        public Node<T> left;
        public Node<T> right;

        public Node() {
        }

        public Node(T t) {
            this.t = t;
        }

        @Override
        public String toString() {
            return t.toString();
        }
    }

    // A B C D E F G H I J K L M
    public static <T> void traverseWidth(Node<T> root) {
        if (root == null) return;
        LinkedList<Node<T>> queue = new LinkedList<>();
        // add remove get vs offer poll peek
        queue.offerFirst(root);
        while (!queue.isEmpty()) {
            Node<T> tmp = queue.pollLast();
            System.out.print(tmp + " ");
            if (tmp.left != null)
                queue.offerFirst(tmp.left);
            if (tmp.right != null)
                queue.offerFirst(tmp.right);
        }
    }

    // A B D H I E J C F K G L M
    public static <T> void traverseDepth(Node<T> root) {
        if (root == null) return;
        System.out.print(root + " ");
        traverseDepth(root.left);
        traverseDepth(root.right);
    }
}
