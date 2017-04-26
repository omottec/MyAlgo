package queue;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 26/04/2017.
 */
public class QueueTest {
    public static void main(String[] args) {
//        Queue<String> q = new LinkedQueue<>();
        Queue<String> q = new ArrayQueue<>();
        String item;
        while (!StdIn.isEmpty()) {
            item = StdIn.readString();
            if (!item.isEmpty()) {
                if ("-".equals(item)) {
                    q.dequeue();
                    StdOut.println("after dequeue: " + q);
                } else {
                    q.enqueue(item);
                    StdOut.println("after enqueue: " + q);
                }
            }
        }
        StdOut.println("queue: " + q);
    }
}
