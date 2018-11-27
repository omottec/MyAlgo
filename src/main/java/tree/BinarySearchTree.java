package tree;

/**
 * Created by qinbingbing on 20/11/2018.
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BinarySearchTreeNode<T> mRoot;

    public class BinarySearchTreeNode<T extends Comparable<T>> {
        T key;
        BinarySearchTreeNode<T> parent;
        BinarySearchTreeNode<T> left;
        BinarySearchTreeNode<T> right;

        public BinarySearchTreeNode(T key, BinarySearchTreeNode<T> parent, BinarySearchTreeNode<T> left, BinarySearchTreeNode<T> right) {
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

    private void preOrder(BinarySearchTreeNode<T> root) {
        if (root == null) return;
        System.out.print(root.key + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    // 中序遍历：左父右
    public void inOrder() {
        inOrder(mRoot);
    }

    private void inOrder(BinarySearchTreeNode<T> root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(root.key + " ");
        inOrder(root.right);
    }

    // 后序遍历：左右父
    public void postOrder() {
        postOrder(mRoot);
    }

    private void postOrder(BinarySearchTreeNode<T> root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.key + " ");
    }

    // 递归查找
    public BinarySearchTreeNode<T> recursiveSearch(T key) {
        if (key == null || mRoot == null) return null;
        return recursiveSearch(mRoot, key);
    }

    private BinarySearchTreeNode<T> recursiveSearch(BinarySearchTreeNode<T> root, T key) {
        int i = key.compareTo(root.key);
        if (i < 0)
            return recursiveSearch(root.left, key);
        else if (i > 0)
            return recursiveSearch(root.right, key);
        else
            return root;
    }

    // 迭代查找
    public BinarySearchTreeNode<T> iterativeSearch(T key) {
        if (key == null || mRoot == null) return null;
        return iterativeSearch(mRoot, key);
    }

    private BinarySearchTreeNode<T> iterativeSearch(BinarySearchTreeNode<T> root, T key) {
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

    // 最大值: 递归
    public T recursiveMax() {
        BinarySearchTreeNode<T> maxNode = recursiveMax(mRoot);
        return maxNode == null ? null : maxNode.key;
    }

    private BinarySearchTreeNode<T> recursiveMax(BinarySearchTreeNode<T> root) {
        if (root == null) return null;
        if (root.right != null)
            return recursiveMax(root.right);
        else
            return root;
    }

    public T iterativeMax() {
        BinarySearchTreeNode<T> maxNode = iterativeMax(mRoot);
        return maxNode == null ? null : maxNode.key;
    }

    private BinarySearchTreeNode<T> iterativeMax(BinarySearchTreeNode<T> root) {
        if (root == null) return null;
        while (root.right != null)
            root = root.right;
        return root;
    }

    // 最小值: 递归
    public T recursiveMin() {
        BinarySearchTreeNode<T> minNode = recursiveMin(mRoot);
        return minNode == null ? null : minNode.key;
    }

    private BinarySearchTreeNode<T> recursiveMin(BinarySearchTreeNode<T> root) {
        if (root == null) return null;
        if (root.left != null)
            return recursiveMin(root.left);
        else
            return root;
    }

    // 最小值：迭代
    public T iterativeMin() {
        BinarySearchTreeNode<T> minNode = iterativeMin(mRoot);
        return minNode == null ? null : minNode.key;
    }

    private BinarySearchTreeNode<T> iterativeMin(BinarySearchTreeNode<T> root) {
        if (root == null) return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    // 前驱节点：小于该节点的最大节点
    public BinarySearchTreeNode<T> predecessor(BinarySearchTreeNode<T> node) {
        if (node == null) return null;
        // tree有左节点，前驱节点为以左节点为根的子树的最大节点
        if (node.left != null) return recursiveMax(node.left);
        // tree没有左节点，有两种可能
        // tree是左节点，则查找tree的最低父节点且该最低父节点要有右节点
        // tree是右节点，前驱节点是tree的父节点
        BinarySearchTreeNode<T> parent = node.parent;
        while (parent != null && parent.left == node) {
            node = parent;
            parent = parent.parent;
        }
        return parent;
    }

    // 后继节点：大于该节点的最小节点
    public BinarySearchTreeNode<T> successor(BinarySearchTreeNode<T> node) {
        if (node == null) return null;
        // tree有右节点，后继节点为以右节点为子树的最小节点
        if (node.right != null) return recursiveMin(node.right);
        // tree没有右节点，有两种可能
        // tree是左节点，后继节点是tree的父节点
        // tree是右节点，后继节点是tree的最低父节点且该最低父节点有左节点
        BinarySearchTreeNode<T> parent = node.parent;
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
        BinarySearchTreeNode<T> node = new BinarySearchTreeNode<>(key, null, null, null);
        if (mRoot == null) {
            mRoot = node;
            return;
        }
        insert(mRoot, node);
    }


    private void insert(BinarySearchTreeNode<T> root, BinarySearchTreeNode<T> node) {
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
        BinarySearchTreeNode<T> node = recursiveSearch(key);
        if (node == null) return;
        // node有两个子节点
        if (node.left != null && node.right != null) {
            BinarySearchTreeNode<T> successor = successor(node);
            node.key = successor.key;
            node = successor;
        }
        // node只有一个子节点或没有子节点
        BinarySearchTreeNode<T> child;
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

    // 打印
    public void print() {
        print(mRoot);
    }

    /**
     *
     * @param node
     */
    private void print(BinarySearchTreeNode<T> node) {
        if (node == null) return;
        if (node.parent == null) {
            System.out.printf("%2d is root\n", node.key);
        } else {
            if (node.parent.left == node) {
                System.out.printf("%2d is %2d's left child\n", node.key, node.parent.key);
            } else {
                System.out.printf("%2d is %2d's right child\n", node.key, node.parent.key);
            }
        }
        print(node.left);
        print(node.right);
    }

    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(95,13,97,23,75,48,83,47,71,82);
        bst.print();
    }
}
