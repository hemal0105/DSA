package org.hm.interviews;

/**
 *
 *
 *      *
 *     * *
 *    *   *
 *   *     *
 *  *       *
 * **********
 *
 */
public class TrianglePattern {
    public static void main(String[] args) {
        printPattern(6);
        System.out.println();
        printPattern(9);
        System.out.println();
        printPattern(4);
    }

    private static void printPattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n*2; j++) {
                if (j == n-i || j == n+i) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        for (int i = 0; i < n*2 + 1; i++) {
            System.out.print("*");
        }
    }
}
