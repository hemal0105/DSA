package org.hm.math;

public class Binary {
    private static void decimalToBinary(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0) {
            int rem = n % 2;
            sb.insert(0, rem);
            n = n / 2;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {
        decimalToBinary(10);
        decimalToBinary(125);
        decimalToBinary(256);
    }
}
