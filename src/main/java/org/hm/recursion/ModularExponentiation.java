package org.hm.recursion;

public class ModularExponentiation {

    // Efficient as it's using below property for O(log n)
    // (a * b) % m = ((a % m) * (b % m)) % m
    private static int mod(int x, int n, int m) {
        if (n == 0) return 1;
        else if (n % 2 == 0) {
            int y = mod(x, n / 2, m);
            return (y * y) % m;
        } else {
            return ((x % m) * mod(x, n - 1, m)) % m;
        }
    }

    public static void main(String[] args) {
        System.out.println(mod(5, 3, 7));
    }
}
