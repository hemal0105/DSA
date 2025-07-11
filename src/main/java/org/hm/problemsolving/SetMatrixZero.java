package org.hm.problemsolving;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMatrixZero {

    // Uses additional Memory
    private static void setZeroes1(int[][] matrix) {
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

    // Uses array's first row/column elements as indicators
    private static void setZeroes2(int[][] matrix) {
        boolean isFirstCol = false;

        int rowLen = matrix.length;
        int colLen = matrix[0].length;

        for (int i = 0; i < rowLen; i++) {

            if (matrix[i][0] == 0) isFirstCol = true;

            for (int j = 1; j < colLen; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        for (int i = 1; i < rowLen; i++) {
            for (int j = 1; j < colLen; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (isFirstCol) {
            for (int i = 1; i < rowLen; i++) {
                matrix[i][0] = 0;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes1(matrix1);
        System.out.println(Arrays.deepToString(matrix1));

        int[][] matrix2 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        setZeroes2(matrix2);
        System.out.println(Arrays.deepToString(matrix2));
    }
}
