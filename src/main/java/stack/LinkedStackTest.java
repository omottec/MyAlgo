package stack;

/**
 * Created by omottec on 07/02/2020.
 */
public class LinkedStackTest {
    public static void main(String[] args) {
        LinkedStack<String> stack = new LinkedStack<String>();
        stack.push("A");
        stack.push("B");
        stack.push("C");
        stack.push("D");
        stack.push("E");
        stack.push("F");
        stack.push("G");
        System.out.println("stack before pop");
        stack.printStack();
        System.out.println("\npop stack");
        String str;
        while ((str = stack.pop()) != null)
            System.out.print(str + " ");
        System.out.println("\nstack after pop");
        stack.printStack();
    }

    public static class LinkedStack<T> {
        public static class Node<T> {
            public T t;
            public Node<T> next;
            public Node(T t) {
                this.t = t;
            }
            public String toString() {
                return t.toString();
            }
        }

        private Node<T> h;

        public void push(T t) {
            Node<T> tmp = new Node<>(t);
            if (h == null) {
                h = tmp;
            } else {
                tmp.next = h;
                h = tmp;
            }
        }

        public T pop() {
            if (h == null) return null;
            T t = h.t;
            h = h.next;
            return t;
        }

        public void printStack() {
            Node<T> tmp = h;
            while (tmp != null) {
                System.out.print(tmp + " ");
                tmp = tmp.next;
            }
        }
    }
}
