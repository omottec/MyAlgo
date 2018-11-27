package tree;

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

    // 前序遍历：父左右
    public void preOrder() {
        preOrder(mRoot);
    }

    private void preOrder(BSTNode<T> root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    // 中序遍历：左父右
    public void inOrder() {
        inOrder(mRoot);
    }

    private void inOrder(BSTNode<T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.key + " ");
            inOrder(root.right);
        }
    }

    // 后序遍历：左右父
    public void postOrder() {
        postOrder(mRoot);
    }

    private void postOrder(BSTNode<T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.key + " ");
        }
    }

    // 递归查找
    public BSTNode<T> search(T key) {
        if (key == null || mRoot == null) return null;
        return search(mRoot, key);
    }

    private BSTNode<T> search(BSTNode<T> root, T key) {
        int i = key.compareTo(root.key);
        if (i < 0)
            return search(root.left, key);
        else if (i > 0)
            return search(root.right, key);
        else
            return root;
    }

    // 迭代查找
    public BSTNode<T> iterativeSearch(T key) {
        if (key == null || mRoot == null) return null;
        return iterativeSearch(mRoot, key);
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
        return null;
    }

    // 最大值
    public T max() {
        BSTNode<T> maxNode = max(mRoot);
        if (maxNode != null)
            return maxNode.key;
        else
            return null;
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

    // 最小值
    public T min() {
        BSTNode<T> minNode = min(mRoot);
        if (minNode != null)
            return minNode.key;
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

    // 前驱节点：小于该节点的最大节点
    public BSTNode<T> predecessor(BSTNode<T> node) {
        if (node == null) return null;
        // tree有左节点，前驱节点为以左节点为根的子树的最大节点
        if (node.left != null) return max(node.left);
        // tree没有左节点，有两种可能
        // tree是左节点，则查找tree的最低父节点且该最低父节点要有右节点
        // tree是右节点，前驱节点是tree的父节点
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

    // 插入
    public void insert(T... keys) {
        for (T key : keys)
            insert(key);
    }

    private void insert(T key) {
        if (key == null) return;
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

    private void delete(T key) {
        if (key == null) return;
        BSTNode<T> node = search(key);
        if (node == null) return;
        // node有两个子节点
        if (node.left != null && node.right != null) {
            BSTNode<T> successor = successor(node);
            node.key = successor.key;
            node = successor;
        }
        // node只有一个子节点或没有子节点
        BSTNode<T> child;
        if (node.right != null)
            child = node.right;
        else
            child = node.left;
        if (child != null)
            child.parent = node.parent;
        if (node.parent == null)
            mRoot = child;
        else if (node.parent.left == node)
            node.parent.left = child;
        else
            node.parent.right = child;
        // 清除引用
        node = null;
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
