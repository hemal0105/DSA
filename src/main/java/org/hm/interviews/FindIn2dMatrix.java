package org.hm.interviews;


/**
 *                 mat[][] = [[3, 30, 38],
 *                           [20, 52, 54],
 *                           [35, 60, 69]]
 * Input: x = 62, Output: -1,-1
 * Input: x = 30, Output: 0,1
 *
 *
 * 1, 1 -> 52
 * rowMid++ -> 2
 *
 */
public class FindIn2dMatrix {
    public static void main(String[] args) {
        int[][] mat = {{3, 30, 38}, {20, 52, 54}, {35, 60, 69}};
        findEle(mat, 30);
        findEle(mat, 54);
        findEle(mat, 62);
    }

    private static void findEle(int[][] mat, int target) {
        int row = mat.length;
        int col = mat[0].length;

        int i = 0;
        for (i = 0; i < row; i++) {
            int serIdx = binSer(mat, i, 0, col-1, target);
            if (serIdx != -1) {
                System.out.println("Found at " + i + "," + serIdx);
                return;
            }
        }

        if (i == row) {
            System.out.println("-1, -1");
        }
    }

    private static int binSer(int[][] mat, int currRow, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) /2;
        if (mat[currRow][mid] == target) {
            return mid;
        } else if (mat[currRow][mid] > target) {
            return binSer(mat, currRow, start, mid-1, target);
        } else {
            return binSer(mat, currRow, mid + 1, end, target);
        }
    }
}
