package ch0103;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 9/29/16.
 */
public class TestStack {
    public static void main(String[] args) {
//        FixedCapacityStackOfStrings s = new FixedCapacityStackOfStrings(100);
//        FixedCapacityStack<String> s = new FixedCapacityStack<String>(100);
//        Stack<String> s = new Stack<>();
        ResizingArrayStack<String> s = new ResizingArrayStack<>();
        String item;
        while (!StdIn.isEmpty()) {
            item = StdIn.readString();
            if (!item.equals("-"))
                s.push(item);
            else if (!item.isEmpty())
                StdOut.println("    " + s.pop());
        }
        System.out.println("(" + s.size() + " left on stack)");
    }
}
