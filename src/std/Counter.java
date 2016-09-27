package std;

import com.omottec.algo.stdio.StdRandom;

import java.util.Arrays;

/**
 * Created by qinbingbing on 9/27/16.
 */
public class Counter implements Comparable<Counter> {
    private final String name;
    private int count;

    public Counter(String name) {
        this.name = name;
    }

    public void increment() {
        count++;
    }

    public int tally() {
        return count;
    }

    @Override
    public String toString() {
        return count + " " + name;
    }

    @Override
    public int compareTo(Counter o) {
        return count - o.count;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trails = Integer.parseInt(args[1]);
        Counter[] counters = new Counter[n];
        for (int i = 0; i < n; i++)
            counters[i] = new Counter("Counter " + i);
        for (int i = 0; i < trails; i++)
            counters[StdRandom.uniform(n)].increment();
        System.out.println(Arrays.toString(counters));
    }
}
