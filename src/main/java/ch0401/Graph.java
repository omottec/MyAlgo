package ch0401;

import ch0103.Bag;
import com.omottec.algo.stdio.In;

/**
 * Created by qinbingbing on 10/18/16.
 */
public class Graph {
    private final int V;    // 顶点数目
    private int E;  // 边的数目
    private Bag<Integer>[] adj; // 邻接表

    public Graph(int V) {
        this.V = V;
        this.E = 0;
        adj = new Bag[V];
        for (int i = 0; i < V; i++)
            adj[i] = new Bag<Integer>();
    }

    public Graph(In in) {
        this(in.readInt());
        int E = in.readInt();
        int v, w;
        for (int i = 0; i < E; i++) {
            v = in.readInt();
            w = in.readInt();
            addEdge(v, w);
        }
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        Iterable<Integer> adj = G.adj(v);
        for (int w : adj) degree++;
        return degree;
    }

    public static int maxDegree(Graph G) {
        int max = 0, degree;
        int V = G.V();
        for (int v = 0; v < V; v++) {
            degree = degree(G, v);
            if (degree > max) max = degree;
        }
        return max;
    }

    public static double avgDegree(Graph G) {
        return 2 * G.E() / G.V();
    }

    public static int numberOfSelfLoops(Graph G) {
        int count = 0;
        int V = G.V();
        Iterable<Integer> adj;
        for (int v = 0; v < V; v++) {
            adj = G.adj(v);
            for (int w : adj)
                if (v == w) count++;
        }
        return count / 2;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(V).append(" vertices, ")
                .append(E).append(" edges\n");
        Iterable<Integer> adj;
        for (int v = 0; v < V; v++) {
            sb.append(v).append(": ");
            adj = adj(v);
            for (int w : adj)
                sb.append(w).append(" ");
            sb.append("\n");
        }
        return sb.toString();
    }
}
