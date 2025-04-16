package org.hm.recursion;

public class Fibonacci {
    private static int findFibIter(int n) {
        if (n <= 1) return n;
        int f1 = 0;
        int f2 = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = f1 + f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }

    private static int findFibRec(int n) {
        if (n <= 1) return n;
        return findFibRec(n-1) + findFibRec(n-2);
    }

    private static final int[] memo = new int[50];
    private static int findFibRecMemo(int n) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        memo[n] = findFibRecMemo(n-1) + findFibRecMemo(n-2);
        return memo[n];
    }

    public static void main(String[] args) {
        System.out.println(findFibIter(6));
        System.out.println(findFibIter(42));

        System.out.println(findFibRec(6));
        // Takes longer time due to exponential time complexity of O(2^n)
        System.out.println(findFibRec(42));

        System.out.println(findFibRecMemo(6));
        System.out.println(findFibRecMemo(42));
    }
}
