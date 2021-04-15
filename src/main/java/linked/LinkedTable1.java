package linked;

public class LinkedTable1 {
    public static void main(String[] args) {
        Node<String > a = new Node<>("a");
        Node<String > b = new Node<>("b");
        Node<String > c = new Node<>("c");
        Node<String > d = new Node<>("d");
        a.next = b;
        b.next = c;
        c.next = d;
        System.out.println("String Table before:" + a);
        a.reverse();
        System.out.println("String Table reverse:" + a);

        Node<Integer> int1 = new Node<>(1);
        Node<Integer> int2 = new Node<>(2);
        Node<Integer> int3 = new Node<>(3);
        Node<Integer> int4 = new Node<>(4);
        int1.next = int2;
        int2.next = int3;
        int3.next = int4;
        System.out.println("Integer Table before:" + int1);
        int1.reverse();
        System.out.println("Integer Table reverse:" + int1);
    }

    public static class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(data);
            Node<T> tmp = next;
            while (tmp != null) {
                sb.append("--->").append(tmp.data);
                tmp = tmp.next;
            }
            return sb.toString();
        }

        public void reverse() {
            Node<T> head = new Node<>(data);
            Node<T> tmp;
            while (next != null) {
                tmp = new Node<>(next.data);
                tmp.next = head;
                head = tmp;
                next = next.next;
            }
            data = head.data;
            next = head.next;
        }
    }


}
