package tree;

import ch0302.BST;

/**
 * Created by qinbingbing on 20/11/2018.
 */
public class BSTree<T extends Comparable<T>> {
    private BSTNode<T> mRoot;

    public class BSTNode<T extends Comparable<T>> {
        T key;
        BSTNode<T> parent;
        BSTNode<T> left;
        BSTNode<T> right;
    }

    private void preOrder(BSTNode<T> tree) {
        if (tree != null) {
            System.out.print(tree.key + " ");
            preOrder(tree.left);
            preOrder(tree.right);
        }
    }

    // 前序遍历：根左右
    public void preOrder() {
        preOrder(mRoot);
    }

    private void inOrder(BSTNode<T> tree) {
        if (tree != null) {
            inOrder(tree.left);
            System.out.println(tree.key + " ");
            inOrder(tree.right);
        }
    }

    // 中序遍历：左根右
    public void inOrder() {
        inOrder(mRoot);
    }

    private void postOrder(BSTNode<T> tree) {
        if (tree != null) {
            postOrder(tree.left);
            postOrder(tree.right);
            System.out.println(tree.key + " ");
        }
    }

    // 后序遍历：左右根
    public void postOrder() {
        postOrder(mRoot);
    }

    private BSTNode<T> search(BSTNode<T> tree, T key) {
        if (tree == null) return tree;
        int i = key.compareTo(tree.key);
        if (i < 0) return search(tree.left, key);
        if (i > 0) return search(tree.right, key);
        return tree;
    }

    // 递归查找
    public BSTNode<T> search(T key) {
        return search(mRoot, key);
    }

    private BSTNode<T> iterativeSearch(BSTNode<T> root, T key) {
        while (root != null) {
            int i = key.compareTo(root.key);
            if (i < 0)
                root = root.left;
            else if (i > 0)
                root = root.right;
            else
                return root;
        }
        return root;
    }

    // 迭代查找
    public BSTNode<T> iterativeSearch(T key) {
        return iterativeSearch(mRoot, key);
    }

    private BSTNode<T> max(BSTNode<T> root) {
        if (root == null) return null;
        if (root.right != null)
            return max(root.right);
        else
            return root;
    }

    private BSTNode<T> iterativeMax(BSTNode<T> root) {
        if (root == null) return null;
        while (root.right != null)
            root = root.right;
        return root;
    }

    // 最大值
    public T max() {
        BSTNode<T> maxNode = max(mRoot);
        if (maxNode != null) return maxNode.key;
        return null;
    }

    private BSTNode<T> min(BSTNode<T> root) {
        if (root == null) return null;
        if (root.left != null)
            return min(root.left);
        else
            return root;
    }

    // 最小值
    public T min() {
        BSTNode<T> minNode = min(mRoot);
        if (minNode != null) return minNode.key;
        return null;
    }

    // 前驱节点：小于该节点的最大节点
    public BSTNode<T> predecessor(BSTNode<T> tree) {
        if (tree == null || tree.left == null) return null;
        return max(tree.left);
    }
}
