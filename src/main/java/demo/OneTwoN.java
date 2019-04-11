package demo;

/**
 * Created by omottec on 11/04/2019.
 */
public class OneTwoN {
    public static void main(String[] args) {
        System.out.println(funByRecursive(1));
        System.out.println(funByRecursive(2));
        System.out.println(funByRecursive(3));
        System.out.println(funByRecursive(4));
        System.out.println(funByRecursive(5));
    }

    private static int funByRecursive(int n) {
        if (n == 1)
            return 1;
        else if (n == 2)
            return 2;
        else
            return funByRecursive(n-1) + funByRecursive(n-2);
    }
}
