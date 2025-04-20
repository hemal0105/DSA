package org.hm.math;

public class PrimeFactors {

    private static void primeFactors(int n) {
        System.out.println("PrimeFactors: " + n);
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                int count = 0;
                while (n % i == 0) {
                    n = n / i;
                    count++;
                }
                System.out.println(i + " - " + count);
            }
        }
        if (n != 1) System.out.println(n + " - 1");
    }

    public static void main(String[] args) {
        primeFactors(36);
        primeFactors(44);
    }
}
