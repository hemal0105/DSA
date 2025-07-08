package org.hm.interviews;

/**
 * 1
 * 2 3
 * 4 5 6
 * 7 8 9 10
 */
public class NumberPattern {

    public static void main(String[] args) {
        int n = 10;

        int col = 1;
        int colIdx = 1;
        for (int j = 1; j <= n; j++) {
            System.out.print(j + " ");
            colIdx++;
            if (colIdx > col) {
                colIdx = 1;
                System.out.println();
                col++;
            }
        }
        System.out.println();
    }
}
