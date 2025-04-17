package org.hm.math;

public class Prime {
    private static boolean isPrime(int n) {
        for (int i = 2; i < Math.sqrt(n); i++)
            if (n % i == 0) return false;
        return true;
    }

    private static void allPrimes(int n) {
        int[] primes = new int[n + 1];
        for (int i = 2; i <= n; i++) primes[i] = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (primes[i] == 1) {
                for (int j = 2; i * j <= n; j++) {
                    primes[i * j] = 0;
                }
            }
        }

        System.out.println("Primes: ");
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 1) {
                System.out.print(i + " ");
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        System.out.println("11: " + isPrime(11));
        System.out.println("121: " + isPrime(121));

        allPrimes(15);
        allPrimes(20);
    }
}
