package queue;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 26/04/2017.
 */
public class QueueTest {
    public static void main(String[] args) {
        Queue<String> q = new LinkedQueue<>();
        String item;
        while (!StdIn.isEmpty()) {
            item = StdIn.readString();
            if (!item.isEmpty()) {
                if ("-".equals(item)) StdOut.println("  " + q.dequeue());
                else q.enqueue(item);
            }
        }
        if (q.size() > 1) StdOut.println(q.size() + " elements left in the queue");
        else StdOut.println(q.size() + " element left in the queue");
        StdOut.println("head:" + q.head());
        StdOut.println("tail:" + q.tail());
    }
}
