package org.hm.problemsolving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {

    private static void setZeroes(int[][] matrix) {
        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < rowLen; i++) {
            for (int j = 0; j < colLen; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes(matrix1);
        System.out.println(Arrays.deepToString(matrix1));
    }
}
