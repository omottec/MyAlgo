package stack;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by qinbingbing on 25/04/2017.
 */
public class StackTest extends TestCase {
    public static void main(String[] args) {
        Stack<String> s = new ArrayStack<>();
//        Stack<String> s = new LinkedStack<>();
        String item;
        while (!StdIn.isEmpty()) {
            item = StdIn.readString();
            if (!item.isEmpty()) {
                if ("-".equals(item))
                    StdOut.println("    " + s.pop());
                else
                    s.push(item);
            }
        }
        StdOut.println(s.size() + (s.isEmpty() ? " element" : " elements") + " left in stack");
    }

    @Test
    public void testArrayStack() {
        Stack<String> s = new ArrayStack<>();
        s.push("a");
        s.push("b");
        s.push("c");
        while (!s.isEmpty())
            StdOut.print(s.pop() + " ");
    }

    @Test
    public void testLinkedStack() {
        Stack<String> s = new LinkedStack<>();
        s.push("aa");
        s.push("bb");
        s.push("cc");
        while (!s.isEmpty())
            StdOut.print(s.pop() + " ");
    }
}
