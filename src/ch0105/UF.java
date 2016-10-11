package ch0105;

import com.omottec.algo.stdio.StdIn;
import com.omottec.algo.stdio.StdOut;

/**
 * Created by qinbingbing on 10/11/16.
 */
public class UF {
    private int[] id;
    private int count;

    public UF(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++)
            id[i] = i;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public int find(int p) {
        return find2(p);
    }

    public void union(int p, int q) {
        union2(p, q);
    }

    private int find1(int p) {
        return id[p];
    }

    private void union1(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) return;
        for (int i = 0; i < id.length; i++)
            if (id[i] == pId) id[i] = qId;
        count--;
    }

    private int find2(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    private void union2(int p, int q) {
        int pRoot = find2(p);
        int qRoot = find2(q);
        if (pRoot == qRoot) return;
        id[pRoot] = qRoot;
        count--;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        UF uf = new UF(n);
        int p, q;
        while (!StdIn.isEmpty()) {
            p = StdIn.readInt();
            q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
