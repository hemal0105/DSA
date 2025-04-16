package org.hm.recursion;

public class Exponentiation {

    // O(n)
    private static int powIter(int x, int n) {
        int res = 1;
        for (int i = 0; i < n; i++) res *= x;
        return res;
    }

    // O(n)
    private static int powRec1(int x, int n) {
        if (n == 0) return 1;
        return x * (powRec1(x, n - 1));
    }

    // O(log n)
    private static int powRec2(int x, int n) {
        if (n == 0) return 1;
        else if (n % 2 == 0) {
            int y = powRec2(x, n / 2);
            return y * y;
        } else {
            return x * powRec2(x, n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(powIter(2, 8));
        System.out.println(powIter(10, 4));

        System.out.println(powRec1(2, 8));
        System.out.println(powRec1(10, 4));

        System.out.println(powRec2(2, 8));
        System.out.println(powRec2(10, 4));
    }
}
