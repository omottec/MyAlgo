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

        public BSTNode(T key, BSTNode<T> parent, BSTNode<T> left, BSTNode<T> right) {
            this.key = key;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private void preOrder(BSTNode<T> root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 前序遍历：根左右
    public void preOrder() {
        preOrder(mRoot);
    }

    private void inOrder(BSTNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    // 中序遍历：左根右
    public void inOrder() {
        inOrder(mRoot);
    }

    private void postOrder(BSTNode<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // 后序遍历：左右根
    public void postOrder() {
        postOrder(mRoot);
    }

    private BSTNode<T> search(BSTNode<T> root, T key) {
        if (root == null) return null;
        int i = key.compareTo(root.key);
        if (i < 0)
            return search(root.left, key);
        else if (i > 0)
            return search(root.right, key);
        else
            return root;
    }

    // 递归查找
    public BSTNode<T> search(T key) {
        assert key != null;
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
        assert key != null;
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
        if (maxNode != null)
            return maxNode.key;
        else
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
        if (minNode != null)
            return minNode.key;
        else
            return null;
    }

    // 前驱节点：小于该节点的最大节点
    public BSTNode<T> predecessor(BSTNode<T> node) {
        if (node == null) return null;
        // tree有左节点，前驱节点为以左节点为根的子树的最大节点
        if (node.left != null) return max(node.left);
        // tree没有左节点，有两种可能
        // tree是右节点，前驱节点是tree的父节点
        // tree是左节点，则查找tree的最低父节点且该最低父节点要有右节点
        BSTNode<T> parent = node.parent;
        while (parent != null && parent.left == node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // 后继节点：大于该节点的最小节点
    public BSTNode<T> successor(BSTNode<T> node) {
        if (node == null) return null;
        // tree有右节点，后继节点为以右节点为子树的最小节点
        if (node.right != null) return min(node.right);
        // tree没有右节点，有两种可能
        // tree是左节点，后继节点是tree的父节点
        // tree是右节点，后继节点是tree的最低父节点且该最低父节点有左节点
        BSTNode<T> parent = node.parent;
        while (parent != null && parent.left != node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    public void insert(T... keys) {
        for (T key : keys)
            insert(key);
    }

    public void insert(T key) {
        assert key != null;
        BSTNode<T> node = new BSTNode<>(key, null, null, null);
        if (mRoot == null) {
            mRoot = node;
            return;
        }
        insert(mRoot, node);
    }


    private void insert(BSTNode<T> root, BSTNode<T> node) {
        int i = node.key.compareTo(root.key);
        if (i < 0) {
            if (root.left == null) {
                root.left = node;
                node.parent = root;
                return;
            } else {
                insert(root.left, node);
            }
        } else if (i > 0) {
            if (root.right == null) {
                root.right = node;
                node.parent = root;
                return;
            } else {
                insert(root.right, node);
            }
        }
    }

    public void delete(T... keys) {
        for (T key : keys)
            delete(key);
    }

    public void delete(T key) {
        assert key != null;
        BSTNode<T> node = search(key);
        if (node == null) return;
        if (node.parent == null) {
            mRoot = null;
            insert(mRoot, node.left);
            insert(mRoot, node.right);
        } else {
            if (node.parent.right == node) {
                node.parent.right = null;
                insert(node.parent, node.left);
                insert(node.parent, node.right);
                node.parent = null;
            } else {
                node.parent.left = null;
                insert(node.parent, node.left);
                insert(node.parent, node.right);
                node.parent = null;
            }
        }
    }

    public static void main(String[] args) {
        BSTree<Integer> bsTree = new BSTree<>();
        bsTree.insert(13,5,15,9,18,2,7,6);
        bsTree.inOrder();
        System.out.println();
        System.out.println(bsTree.min());
        System.out.println(bsTree.max());
    }
}
