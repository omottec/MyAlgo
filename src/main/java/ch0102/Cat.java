package ch0102;

import com.omottec.algo.stdio.In;
import com.omottec.algo.stdio.Out;

/**
 * Created by qinbingbing on 9/28/16.
 */
public class Cat {
    public static void main(String[] args) {
        int length = args.length;
        Out out = new Out(args[length - 1]);
        try {
            In in = null;
            for (int i = 0; i < length-1; i++) {
                in = new In(args[i]);
                out.println(in.readAll());
                in.close();
            }
        } finally {
            out.close();
        }
    }
}
