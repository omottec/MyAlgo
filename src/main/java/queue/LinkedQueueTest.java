package queue;

/**
 * Created by omottec on 07/02/2020.
 */
public class LinkedQueueTest {
    public static void main(String[] args) {
        LinkedQueue<String> queue = new LinkedQueue<>();
        queue.add("A");
        queue.add("B");
        queue.add("C");
        queue.add("D");
        queue.add("E");
        System.out.println("queue before remove");
        queue.print();
        System.out.println("\nqueue remove");
        String str;
        while ((str = queue.remove()) != null)
            System.out.print(str + " ");
        System.out.println("\nqueue after remove");
        queue.print();
    }

    public static class LinkedQueue<T> {
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
        private Node<T> head;
        private Node<T> tail;

        public void add(T t) {
            Node<T> tmp = new Node<>(t);
            if (tail == null) {
                tail = tmp;
                head = tmp;
            } else {
                tail.next = tmp;
                tail = tmp;
            }
        }

        public T remove() {
            if (head == null) return null;
            T tmp = head.t;
            head = head.next;
            if (head == null) tail = null;
            return tmp;
        }

        public void print() {
            Node<T> tmp = head;
            while (tmp != null) {
                System.out.print(tmp + " ");
                tmp = tmp.next;
            }
        }
    }
}
