package linked;

/**
 * Created by omottec on 06/02/2020.
 */
public class LinkedTable {
    public static void main(String[] args) {
//        Node<String> head = new Node<>();
//        head.t = "Q";
//        Node h = head;
//        Node tmp;
//        char[] chars = "LinkedTable".toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            tmp = new Node();
//            tmp.t = chars[i];
//            h.next = tmp;
//            h = tmp;
//        }

        Node<Integer> head = new Node<>();
        head.t = 0;
        Node<Integer> h = head;
        Node<Integer> tmp;
        for (int i = 1; i < 10; i++) {
            tmp = new Node<>();
            tmp.t = i;
            h.next = tmp;
            h = tmp;
        }

        System.out.println("before reverse:");
        printLinkedTable(head);
        System.out.println("after reverse:");
        printLinkedTable(reverse(head));
    }

    public static class Node<T> {
        public T t;
        public Node<T> next;

        @Override
        public String toString() {
            return t.toString();
        }
    }

    public static <T> Node<T> reverse(Node<T> head) {
        Node<T> h = new Node();
        h.t = head.t;
        Node<T> tmp;
        while (head.next != null) {
            head = head.next;
            tmp = new Node<>();
            tmp.t = head.t;
            tmp.next = h;
            h = tmp;
        }
        return h;
    }

    public static <T> void printLinkedTable(Node<T> head) {
        System.out.print(head.t + " ");
        while (head.next != null) {
            head = head.next;
            System.out.print(head.t + " ");
        }
        System.out.println();
    }
}
