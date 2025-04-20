package org.hm.math;

// Greatest Common Divisor
public class Gcd {

    private static int gcd(int a, int b) {
        while (b != 0) {
            int reminder = a % b;
            a = b;
            b = reminder;
        }
        return a;
    }

    private static int gcdRec(int a, int b) {
        return b == 0 ? a : gcd(b , a % b);
    }

    public static void main(String[] args) {
        System.out.println(gcd(105, 350));
        System.out.println(gcd(400, 124));

        System.out.println(gcdRec(105, 350));
        System.out.println(gcdRec(400, 124));
    }
}
